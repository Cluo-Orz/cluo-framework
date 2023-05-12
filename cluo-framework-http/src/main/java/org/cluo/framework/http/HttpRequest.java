package org.cluo.framework.http;


import org.cluo.framework.http.api.JsonHandler;
import org.cluo.framework.reflection.ReflectUtil;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HttpRequest<RESPONSE_CONTENT> {
    private Long timeout = 30000L;
    private Object tag;
    private String uri;
    private Boolean log = true;
    private org.cluo.framework.http.Method method;
    private Map<String, String> requestHeader;
    private Map<String, Object> requestParam;
    private Map<String, String> responseHeader;

    private Class<RESPONSE_CONTENT> responseContentClass;
    private HttpContentType responseContentType;


    private HttpRequest() {
        requestHeader = new LinkedHashMap<>();
        requestParam = new LinkedHashMap<>();
        responseHeader = new LinkedHashMap<>();
        tag = Thread.currentThread().getName().hashCode();
    }

    private HttpRequest(Object tag) {
        this();
        this.tag = tag;
    }

    public static Method createRequest(String uri) {
        Method method = new Method(new HttpRequest());
        method.request.uri = uri;
        return method;
    }

    public static Method createRequest(String uri, Object tag) {
        Method method = new Method(new HttpRequest(tag));
        method.request.uri = uri;
        return method;
    }

    public static class Method {
        private HttpRequest request;

        private Method(HttpRequest request) {
            this.request = request;
        }

        public Header GET() {
            request.method = org.cluo.framework.http.Method.GET;
            return new Header(request);
        }

        public Header DELETE() {
            request.method = org.cluo.framework.http.Method.DELETE;
            return new Header(request);
        }

        public Header OPTION() {
            request.method = org.cluo.framework.http.Method.OPTION;
            return new Header(request);
        }

        public Header PATCH() {
            request.method = org.cluo.framework.http.Method.PATCH;
            return new Header(request);
        }

        public Header POST() {
            request.method = org.cluo.framework.http.Method.POST;
            return new Header(request);
        }

        public Header PUT() {
            request.method = org.cluo.framework.http.Method.PUT;
            return new Header(request);
        }
    }

    public static class Header {
        private HttpRequest request;

        private Header(HttpRequest request) {
            this.request = request;
        }

        public Header addHeader(String key, String value) {
            request.requestHeader.put(key, value);
            return this;
        }

        public Header addAllHeader(Map<String, String> requestHeader) {
            request.requestHeader.putAll(requestHeader);
            return this;
        }

        public QueryParam addParameter(String key, String value) {
            request.requestParam.put(key, value);
            return new QueryParam(request);
        }

        public QueryParam addAllParameter(Map<String, String> requestParam) {
            request.requestParam.putAll(requestParam);
            return new QueryParam(request);
        }

        public QueryParam addAllParameter(Object object) {
            if (object != null) {
                Class clazz = object.getClass();
                List<Field> fields = ReflectUtil.getFields(clazz);
                if (fields != null && fields.size() != 0) {
                    fields.forEach(field -> {

                        Object value = ReflectUtil.getValue(object, field);
                        if (value != null) {
                            request.requestParam.put(field.getName(), value);
                        }
                    });
                }
            }
            return new QueryParam(request);
        }

        public QueryParam noneParam() {
            return new QueryParam(request);
        }

        public QueryParam noneHeader() {
            return new QueryParam(request);
        }
    }

    public static class QueryParam {
        private HttpRequest request;

        private QueryParam(HttpRequest request) {
            this.request = request;
        }

        public QueryParam addParameter(String key, Object value) {
            request.requestParam.put(key, value);
            return this;
        }

        public QueryParam addAllParameter(Map<String, String> requestParam) {
            request.requestParam.putAll(requestParam);
            return this;
        }

        public <RESPONSE_CONTENT> HttpRequest<RESPONSE_CONTENT> setResponseClass(Class<RESPONSE_CONTENT> clazz, HttpContentType contentType) {
            request.responseContentType = contentType;
            request.responseContentClass = clazz;
            return request;
        }

        public <RESPONSE_CONTENT> HttpRequest<RESPONSE_CONTENT> setResponseClass(Class<RESPONSE_CONTENT> clazz) {
            request.responseContentType = HttpContentType.JSON;
            request.responseContentClass = clazz;
            return request;
        }

        public HttpRequest<String> stringResponse() {
            request.responseContentType = HttpContentType.STRING;
            request.responseContentClass = null;
            return request;
        }

        public HttpRequest<Map> mapResponse() {
            request.responseContentType = HttpContentType.JSON;
            request.responseContentClass = Map.class;
            return request;
        }

        public HttpRequest<byte[]> bytesResponse() {
            request.responseContentType = HttpContentType.BYTES;
            request.responseContentClass = byte[].class;
            return request;
        }

        public HttpRequest noneResponse() {
            request.responseContentType = HttpContentType.STRING;
            request.responseContentClass = null;
            return request;
        }
    }

    public RESPONSE_CONTENT send(Object requestContent, HttpContentType contentType) {
        HttpResponse response = sendWithAll(requestContent, contentType);
        return response.getResponseBody();
    }

    public HttpResponse sendWithAll(Object requestContent, HttpContentType contentType) {
        if (tag == null) {
            tag = new Random().nextInt(6);
        }
        String contentStr = null;
        if (requestContent != null) {
            if (HttpContentType.JSON.equals(contentType)) {
                requestHeader.put("Content-Type", "application/json");
                try {
                    if (String.class.equals(requestContent.getClass())) {
                        contentStr = (String) requestContent;
                    } else if (List.class.isAssignableFrom(requestContent.getClass())
                            || Map.class.isAssignableFrom(requestContent.getClass())) {
                        contentStr = HttpBeanContext.jsonHandler.toJsonString(requestContent);
                    } else {
                        contentStr = HttpBeanContext.jsonHandler.toJsonString(requestContent);
                    }
                } catch (Exception e) {
                    throw new HttpException(requestContent + "解析异常", e);
                }
            } else if (HttpContentType.STRING.equals(contentType)) {
                contentStr = String.valueOf(requestContent);
            } else if (HttpContentType.MULTIPART.equals(contentType)) {
                requestHeader.put("Content-Type", "multipart/form-data");
            } else {
                throw new RuntimeException("还未实现" + contentType + "数据传输");
            }
        }
        StringBuilder url = new StringBuilder(uri);
        if (requestParam != null && requestParam.size() > 0) {
            Iterator<Map.Entry<String, Object>> i = requestParam.entrySet().iterator();
            boolean firstIntoLoop = true;
            while (i.hasNext()) {
                Map.Entry<String, Object> entry = i.next();
                if (firstIntoLoop) {
                    url.append("?");
                    firstIntoLoop = false;
                } else {
                    url.append("&");
                }
                Object value = entry.getValue();
                if (value != null) {
                    try {
                        url.append(entry.getKey()).append("=").append(URLEncoder.encode(value.toString(), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        int hashCode = url.hashCode();
        if (log && HttpBeanContext.logger != null) {
            HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> request => " + method.name() + " " + url);
        }
        if (log && HttpBeanContext.logger != null) {
            HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> request header => " + requestHeader.toString());
        }
        if (contentStr != null) {
            if (log && HttpBeanContext.logger != null) {
                HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> request data => " + contentStr);
            }
        }
        HttpResponse response = null;
        response = HttpClient.send(
                url.toString(),
                method.name(),
                contentStr,
                requestHeader,
                uri.startsWith("https"),
                timeout,
                log,
                tag
        );
        if (response.getCode() != 200) {
            if (HttpBeanContext.logger != null) {
                HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> response header => " + response.getHeader().toString());
            }
            byte[] responseData = response.getContent();
            String responseStr = new String(responseData);
            if (HttpBeanContext.logger != null) {
                HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> response error => " + responseStr);
            }
            return response;
        }
        byte[] responseData = response.getContent();
        if (HttpContentType.BYTES.equals(responseContentType)) {
            if (log && HttpBeanContext.logger != null) {
                HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> response bytes length => " + responseData.length);
            }
            return response;
        }

        try {
            String responseStr = new String(responseData, "utf-8");
            if (log && HttpBeanContext.logger != null) {
                HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> response header => " + response.getHeader().toString());
            }
            if (log && HttpBeanContext.logger != null) {
                HttpBeanContext.logger.info("<" + tag + "> <" + hashCode + "> response data => " + responseStr);
            }
            if (responseContentType == null) {
                responseContentType = HttpContentType.STRING;
            }
            switch (responseContentType) {
                case JSON:
                    try {
                        response.responseBody = HttpBeanContext.jsonHandler.toObject(responseStr, responseContentClass);
                    } catch (Exception e) {
                        if (log && HttpBeanContext.logger != null) {
                            HttpBeanContext.logger.error("<" + tag + "> <" + hashCode + "> parse response data error to " + responseContentClass + " => " + responseStr + "\n" + errorMsg(e));
                        }
                        response.responseBody = null;
                    }
                    break;
                case OBJECT:
                    response.responseBody = HttpBeanContext.jsonHandler.toObject(responseStr, responseContentClass);
                    break;
                case STRING:
                    response.responseBody = (RESPONSE_CONTENT) responseStr;
                    break;
                default:
                    response.responseBody = null;
            }

        } catch (UnsupportedEncodingException e) {
            response.responseBody = null;
        }
        return response;
    }

    public RESPONSE_CONTENT send() {
        return send(null, null);
    }

    public HttpResponse sendWithAll() {
        return sendWithAll(null, null);
    }

    public HttpRequest<RESPONSE_CONTENT> timeout(Long timeout) {
        this.timeout = timeout;
        return this;
    }

    public HttpRequest<RESPONSE_CONTENT> log(boolean log) {
        this.log = log;
        return this;
    }

    public HttpRequest<RESPONSE_CONTENT> keepAlive(int connectionCount) {
        requestHeader.put("Connection", "Keep-Alive; max=" + connectionCount);
        requestHeader.put("Transfer-Encodin", "chunked");
        return this;
    }

    public HttpRequest<RESPONSE_CONTENT> keepAlive() {
        requestHeader.put("Connection", "Keep-Alive");
        requestHeader.put("Transfer-Encodin", "chunked");
        return this;
    }

    public static String errorMsg(Throwable throwable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        throwable.printStackTrace(printWriter);
        return result.toString();
    }
}