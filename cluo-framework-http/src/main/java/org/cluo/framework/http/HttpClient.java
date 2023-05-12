package org.cluo.framework.http;

import org.cluo.framework.http.ssl.BaseX509TrustManager;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class HttpClient {
    public final static long TIME_OUT = 120L;


    static {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, new TrustManager[]{new BaseX509TrustManager()}, new java.security.SecureRandom());
            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpResponse send(String uri, String method, String content, Map<String, String> header, boolean isHttps, Long timeout, boolean log, Object tag) {
        HttpResponse response = new HttpResponse();
        URL url = null;
        try {
            url = new URL(uri);
        } catch (Exception e) {
            throw new HttpException(uri + " could not recognized: " + e.getMessage(), e);
        }
        HttpURLConnection connection = null;
        try {
            if (isHttps) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                // TODO: 2019/11/19 有问题就把下面的一句话注释去掉
//                httpsURLConnection.setSSLSocketFactory(HttpsURLConnection.getDefaultSSLSocketFactory());
                connection = httpsURLConnection;
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }
        } catch (Exception e) {
            throw new HttpException(uri + " connection error: " + e.getMessage(), e);
        }
        connection.setConnectTimeout(timeout.intValue());
        connection.setReadTimeout(timeout.intValue());
        connection.setInstanceFollowRedirects(false);
        try {
            connection.setRequestMethod(method);
        } catch (Exception e) {
            throw new HttpException("method <" + method + "> could not recognized.", e);
        }
        if (header != null) {
            Iterator<Map.Entry<String, String>> i = header.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<String, String> entry = i.next();
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (header.getOrDefault("Content-Type", "").equals("multipart/form-data")) {

        } else if (content != null && content.length() > 0) {
            connection.setDoOutput(true);
            OutputStream os = null;
            try {
                os = connection.getOutputStream();
                os.write(content.getBytes("utf-8"));
                os.flush();
                os.close();
            } catch (Exception e) {
                throw new HttpException("send to " + uri + " <" + method + "> is failed: " + e.getMessage(), e);
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        throw new HttpException("send to " + uri + " <" + method + "> error: " + e.getMessage(), e);

                    }
                }
            }
        }
        InputStream is = null;
        try {
            if (connection.getResponseCode() / 100 == 2) {
                is = connection.getInputStream();
                Map<String, List<String>> headerFields = connection.getHeaderFields();
                if (headerFields.containsKey("Content-Encoding") && headerFields.get("Content-Encoding").contains("gzip")) {
                    is = new GZIPInputStream(new BufferedInputStream(is));
                }
            } else {
                is = connection.getErrorStream();
            }
        } catch (Exception e) {
            throw new HttpException("read from " + uri + " <" + method + "> is failed: " + e.getMessage(), e);
        }
        byte[] bytes = new byte[0];

        boolean[] readFinished = {false};
        try {
            if (is != null) {
                ByteArrayOutputStream[] os = {new ByteArrayOutputStream()};
                try {
                    byte[] temp = new byte[4096];
                    int n = 0;
                    final long timestamp = System.currentTimeMillis();
                    HttpURLConnection finalConnection = connection;
                    if (log) {
                        new Thread(() -> {
                            try {
                                int lastSize = 0;
                                int count = 0;
                                while (!readFinished[0]) {
                                    long now = System.currentTimeMillis() - timestamp;
                                    count++;
                                    int size = os[0].size();
                                    if (count > 10 && count % 10 == 0) {
                                        String unit = "B";
                                        int intervalSize = (size - lastSize);
                                        int unitSize = 1024;
                                        if (intervalSize > (unitSize = 1024)) {
                                            unit = "k" + unit;
                                        } else if (intervalSize > (unitSize = 1024 * 1024)) {
                                            unit = "m" + unit;
                                        } else {
                                            unitSize = 1;
                                        }
                                        BigDecimal sizeFinal = BigDecimal.valueOf(intervalSize).divide(BigDecimal.valueOf(unitSize), 2, RoundingMode.HALF_UP);
                                        if (HttpBeanContext.logger != null) {
                                            HttpBeanContext.logger.info("<" + tag + "> download => " + size + "/" + finalConnection.getHeaderField("Content-Length") + " " + sizeFinal.toPlainString() + unit + "/s");
                                        }
                                    }
                                    lastSize = size;
                                    Thread.sleep(1000);
                                }
                            } catch (Exception ignore) {

                            }
                        }).start();
                    }
                    while (-1 != (n = is.read(temp))) {
                        os[0].write(temp, 0, n);
                    }
                    bytes = os[0].toByteArray();
                } catch (Exception e) {
                    try {
                        os[0].close();
                    } catch (IOException e1) {
                        throw new HttpException(e1.getMessage(), e1);
                    }
                } finally {
                    readFinished[0] = true;
                }

            }

            response.content = bytes;
            response.code = connection.getResponseCode();
            Map<String, String> responseHeader = new HashMap<>();
            for (Map.Entry<String, List<String>> stringListEntry : connection.getHeaderFields().entrySet()) {
                List<String> value = stringListEntry.getValue();
                if (value != null && value.size() > 0) {
                    if (!responseHeader.containsKey(stringListEntry.getKey())) {
                        responseHeader.put(stringListEntry.getKey(), "");
                    }
                    for (int i = 0; i < value.size(); i++) {
                        responseHeader.put(stringListEntry.getKey(), responseHeader.get(stringListEntry.getKey()) + value.get(i) + ";");
                    }

                } else {
                    responseHeader.put(stringListEntry.getKey(), "");
                }
            }
            response.header = responseHeader;

        } catch (Exception e) {
            throw new HttpException("read from " + uri + " <" + method + "> error: " + e.getMessage(), e);
        } finally {

            connection.disconnect();
        }

        return response;
    }

    protected static HttpResponse send(String uri, String method, String content, Map<String, String> header, boolean isHttps, Object tag) {
        return send(uri, method, content, header, isHttps, TIME_OUT, true, tag);
    }

    public static byte[] postToByte(String uri, String content, Map<String, String> header, Object tag) {
        return send(uri, "POST", content, header, uri.startsWith("https"), tag).content;
    }

    public static byte[] getToByte(String uri, Map<String, String> header, Object tag) {
        return send(uri, "GET", null, header, uri.contains("https"), tag).content;
    }

    public static String post(String url, String content, Object tag) {
        try {
            return new String(send(url, "POST", content, null, url.contains("https"), tag).content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new HttpException(e.getMessage(), e);
        }
    }

    public static String post(String url, Map<String, String> header, Object tag) {
        try {
            return new String(send(url, "POST", null, null, url.contains("https"), tag).content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new HttpException(e.getMessage(), e);
        }
    }

    public static String get(String url, Object tag) {
        try {
            return new String(send(url, "GET", null, null, url.contains("https"), tag).content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new HttpException(e.getMessage(), e);
        }
    }

    public static String get(String url, Map<String, String> header, Object tag) {
        try {
            return new String(send(url, "GET", null, header, url.contains("https"), tag).content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new HttpException(e.getMessage(), e);
        }
    }
}