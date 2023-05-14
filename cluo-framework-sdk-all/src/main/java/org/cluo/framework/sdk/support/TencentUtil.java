package org.cluo.framework.sdk.support;

import com.fasterxml.jackson.core.type.TypeReference;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.cluo.framework.http.Method;
import org.cluo.framework.json.JSONUtil;
import org.cluo.framework.sdk.all.tencent.api.live.LiveEntity;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.*;
import java.util.*;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * In yiming-xin.dayukeji.common.util
 * Create in 11:35 2018/7/20
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class TencentUtil {
    public static final String RTMP_PREFFIX = "rtmp://";
    public static final String RTMP_SUFFIX = "";
    public static final String FLV_PREFFIX = "http://";
    public static final String FLV_SUFFIX = ".flv";
    public static final String HLS_PREFFIX = "http://";
    public static final String HLS_SUFFIX = ".m3u8";
    public static final String ORIGIN = "";
    public static final String SD = "_550";
    public static final String HD = "_900";


    public static String encodeBase64(byte[] b) {
        try {
            return URLEncoder.encode(Base64.getEncoder().encodeToString(b), "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static byte[] byteMerger(byte[] byte1, byte[] byte2) {
        byte[] byte3 = new byte[byte1.length + byte2.length];
        System.arraycopy(byte1, 0, byte3, 0, byte1.length);
        System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);
        return byte3;
    }

    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String mediaSignByObject(Object obj, String url, Method method, String secret, CodeUtil.SecretType secretType){
        String data = null;
        // 转化obj为参数
        StringBuilder builder = new StringBuilder();
        String s = JSONUtil.fromObjectAsString(obj);
        HashMap map = JSONUtil.toObjectFromString(s, HashMap.class);
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        //升序排序
        list.sort(Comparator.comparing(Map.Entry::getKey));
        list.forEach(stringStringEntry -> {
            Object key = stringStringEntry.getKey();
            Object value = stringStringEntry.getValue();
            if (key != null && value != null && !(value instanceof List)) {
                builder.append(key).append("=").append(value).append("&");
            }else {
                String valueString = JSONUtil.fromObjectAsString(value);
                List<HashMap> hashMaps = JSONUtil.toListFromString(valueString, HashMap.class);
                for (int i = 0; i < hashMaps.size(); i++) {
                    List<Map.Entry<String, String>> valueList = new ArrayList<Map.Entry<String, String>>(hashMaps.get(i).entrySet());
                    for (int k = 0; k < valueList.size(); k++) {
                        Object subKey = valueList.get(k).getKey();
                        Object subValue = valueList.get(k).getValue();
                        builder.append(key+ "." + i + "." + subKey).append("=").append(subValue).append("&");
                    }
                }

            }
        });
        if (builder.length() > 0) {
            data = CharUtil.removeLastChar(builder);
        }else {
            return "";
        }
        // 准备加密
        if (secret == null || secretType == null) {
            return null;
        }
        String tempUrl = url;
        tempUrl = tempUrl.replace("http://", "");
        tempUrl = tempUrl.replace("https://", "");
        // 替换前缀
        String temp = "";
        if (!url.contains("?")) {
            temp = "?";
        } else {
            temp = "&";
        }
        // 拼接url
        data = method + tempUrl + temp + data;
        // 加密
        byte[] singnature = CodeUtil.encodeBySHASource(data, secret, secretType);
        // 转码
        return TencentUtil.encodeBase64(singnature);
    }
    /**
     * @param key    防盗链key
     * @param bizid  管理账号id
     * @param roomId 直播id
     * @param txTime 过期日期毫秒值
     * @param playDomain playDomain
     * @param pushDomain pushDomain
     * @return liveentity
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    public static LiveEntity newLiveEntity(String key, String bizid, String roomId, long txTime,String pushDomain,String playDomain) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input = new StringBuilder().
                append(key).
                append(bizid + "_" + roomId).
                append(Long.toHexString(txTime / 1000L).toUpperCase()).toString();
        String txSecret = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            txSecret = byteArrayToHexString(messageDigest.digest(input.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
        if (txSecret == null) {
            return null;
        }
        String params = "txSecret=" + txSecret + "&" +
                "txTime=" + Long.toHexString(txTime / 1000).toUpperCase();
        String pushRtmp = "rtmp://" + pushDomain + "/live/" + bizid + "_" + roomId + "?" + params;

        LiveEntity liveEntity = new LiveEntity();
        liveEntity.setPushRtmp(pushRtmp);
        String playBody = playDomain+"/live/" + bizid + "_" + roomId;

        liveEntity.setRtmp(RTMP_PREFFIX + playBody + RTMP_SUFFIX);
        liveEntity.setFlv(FLV_PREFFIX + playBody + FLV_SUFFIX);
        liveEntity.setHls(HLS_PREFFIX + playBody + HLS_SUFFIX);

        liveEntity.setRtmpSD(RTMP_PREFFIX + playBody + SD + RTMP_SUFFIX);
        liveEntity.setFlvSD(FLV_PREFFIX + playBody + SD + FLV_SUFFIX);
        liveEntity.setHlsSD(HLS_PREFFIX + playBody + SD + HLS_SUFFIX);

        liveEntity.setRtmpHD(RTMP_PREFFIX + playBody + HD + RTMP_SUFFIX);
        liveEntity.setFlvHD(FLV_PREFFIX + playBody + HD + FLV_SUFFIX);
        liveEntity.setHlsHD(HLS_PREFFIX + playBody + HD + HLS_SUFFIX);
        return liveEntity;
    }

    private static String byteArrayToHexString(byte[] data) {
        char[] out = new char[data.length << 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }

    static byte base64_table_url[] =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '-', '\0'};

    static byte base64_pad_url = '_';

    static short base64_reverse_table_url[] = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
    };

    public static int unsignedToBytes(int b) {
        return b & 0xFF;
    }

    //int base64_encode_url(const unsigned char *in_str, int length, char *out_str,int *ret_length)
    public static byte[] base64EncodeUrl(byte[] in_str) {
        byte[] out_str = new byte[1024];

        int out_current = 0;
        int current = 0;
        int length = in_str.length;

        while (length > 2) { /* keep going until we have less than 24 bits */

            out_str[out_current++] = base64_table_url[unsignedToBytes((unsignedToBytes(in_str[current]) >>> 2))];
            out_str[out_current++] = base64_table_url[unsignedToBytes(unsignedToBytes(unsignedToBytes(in_str[current]) & 0x03) << 4) + unsignedToBytes((unsignedToBytes(in_str[current + 1]) >>> 4))];
            out_str[out_current++] = base64_table_url[(unsignedToBytes((unsignedToBytes(in_str[current + 1]) & 0x0f)) << 2) + unsignedToBytes((unsignedToBytes(in_str[current + 2]) >>> 6))];
            out_str[out_current++] = base64_table_url[unsignedToBytes((unsignedToBytes(in_str[current + 2]) & 0x3f))];
            current += 3;
            length -= 3; /* we just handle 3 octets of data */
        }

        /* now deal with the tail end of things */
        if (length != 0) {
            out_str[out_current++] = base64_table_url[unsignedToBytes(in_str[current]) >>> 2];
            if (length > 1) {
                out_str[out_current++] = base64_table_url[unsignedToBytes((unsignedToBytes(in_str[current]) & 0x03) << 4) + unsignedToBytes(unsignedToBytes(in_str[current + 1]) >>> 4)];
                out_str[out_current++] = base64_table_url[unsignedToBytes((unsignedToBytes(in_str[current + 1]) & 0x0f) << 2)];
                out_str[out_current++] = base64_pad_url;
            } else {
                out_str[out_current++] = base64_table_url[unsignedToBytes((unsignedToBytes(in_str[current]) & 0x03) << 4)];
                out_str[out_current++] = base64_pad_url;
                out_str[out_current++] = base64_pad_url;
            }
        }

        //System.out.println("length in base64EncodeUrl: " + out_current );
        byte[] out_bytes = new String(out_str).getBytes();
        return Arrays.copyOfRange(out_bytes, 0, out_current);
    }

    //int base64_decode_url(const unsigned char *in_str, int length, char *out_str, int *ret_length)
    public static byte[] base64DecodeUrl(byte[] in_str) {
        //        const unsigned char *current = in_str;
        int ch, i = 0, j = 0, k;

        int current = 0;
        int result = 0;
        byte[] out_str = new byte[1024];
        int length = in_str.length;
        /* this sucks for threaded environments */

        /* run through the whole string, converting as we go */
        //while ((ch = in_str[current++]) != '\0' && length-- > 0) {
        ch = in_str[0];
        while (length-- > 0) {
            ch = in_str[current++];
            if (ch == base64_pad_url) break;
	                /* When Base64 gets POSTed, all pluses are interpreted as spaces.
	                   This line changes them back.  It's not exactly the Base64 spec,
	                   but it is completely compatible with it (the spec says that
	                   spaces are invalid).  This will also save many people considerable
	                   headache.  - Turadg Aleahmad <turadg@wise.berkeley.edu>
	            */
            if (ch == ' ') ch = '*'; //never using '+'

            ch = base64_reverse_table_url[ch];
            if (ch < 0) continue;

            switch (i % 4) {
                case 0:
                    out_str[j] = (byte) unsignedToBytes(unsignedToBytes(ch) << 2);
                    break;
                case 1:
                    out_str[j++] |= (byte) unsignedToBytes(unsignedToBytes(ch) >>> 4);
                    out_str[j] = (byte) unsignedToBytes(unsignedToBytes(unsignedToBytes(ch) & 0x0f) << 4);
                    break;
                case 2:
                    out_str[j++] |= (byte) unsignedToBytes(unsignedToBytes(ch) >>> 2);
                    out_str[j] = (byte) unsignedToBytes(unsignedToBytes(unsignedToBytes(ch) & 0x03) << 6);
                    break;
                case 3:
                    out_str[j++] |= (byte) unsignedToBytes(ch);
                    break;
            }
            i++;
        }
        k = j;
        /* mop things up if we ended on a boundary */
        if (ch == base64_pad_url) {
            switch (i % 4) {
                case 0:
                case 1:
                    byte[] error = new byte[1];
                    error[0] = '\0';
                    return error;
                case 2:
                    k++;
                case 3:
                    out_str[k++] = 0;
            }
        }
        return Arrays.copyOfRange(out_str, 0, j);
    }


    public static class TlsSigature {
        public static class GenTLSSignatureResult {
            public String errMessage;
            public String urlSig;
            public int expireTime;
            public int initTime;

            public GenTLSSignatureResult() {
                errMessage = "";
                urlSig = "";
            }
        }

        public static class CheckTLSSignatureResult {
            public String errMessage;
            public boolean verifyResult;
            public int expireTime;
            public int initTime;

            public CheckTLSSignatureResult() {
                errMessage = "";
                verifyResult = false;
            }
        }

        public static void main(String[] args) {
            try {
                //Use pemfile keys to test
                String privStr = "-----BEGIN PRIVATE KEY-----\\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQg3/YENhNIJEndr3eo\\nXsFVeXOj9G4nqxcKVWVACqARfyqhRANCAATDExVvSPbrQKvVf3OII0gKqTFitYG4\\nyfcMsVjGNp3lBca9IHbsZLkiejbI7w8N9MbzLD+M9zB76C2ot2KCSjPG\\n-----END PRIVATE KEY-----";

                //change public pem string to public string
                String pubStr = "-----BEGIN PUBLIC KEY-----\\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEwxMVb0j260Cr1X9ziCNICqkxYrWB\\nuMn3DLFYxjad5QXGvSB27GS5Ino2yO8PDfTG8yw/jPcwe+gtqLdigkozxg==\\n-----END PUBLIC KEY-----";

                // generate signature
                GenTLSSignatureResult result = GenTLSSignatureEx(1400151533, "manager", privStr);
                if (0 == result.urlSig.length()) {
                    System.out.println("GenTLSSignatureEx failed: " + result.errMessage);
                    return;
                }

                System.out.println("---\ngenerate sig:\n" + result.urlSig + "\n---\n");
//
//                // check signature
//                CheckTLSSignatureResult checkResult = CheckTLSSignatureEx(result.urlSig, 1400121171, "yeo", pubStr);
//                if (checkResult.verifyResult == false) {
//                    System.out.println("CheckTLSSignature failed: " + result.errMessage);
//                    return;
//                }

//                System.out.println("\n---\ncheck sig ok -- expire time " + checkResult.expireTime + " -- init time " + checkResult.initTime + "\n---\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * @param expire      有效期，单位是秒，推荐一个月
         * @param strAppid3rd 填写与 sdkAppid 一致字符串形式的值
         * @param skdAppid    应用的 appid
         * @param identifier  用户 id
         * @param accountType 创建应用后在配置页面上展示的 acctype
         * @param privStr     生成 tls 票据使用的私钥内容
         * @return 如果出错，GenTLSSignatureResult 中的 urlSig为空，errMsg 为出错信息，成功返回有效的票据
         * @throws IOException IOException
         * brief 生成 tls 票据
         */
        @Deprecated
        public static GenTLSSignatureResult GenTLSSignature(long expire,
                                                            String strAppid3rd, long skdAppid,
                                                            String identifier, long accountType,
                                                            String privStr) throws IOException {
            privStr = privStr.replace("\\n", "\n");
            GenTLSSignatureResult result = new GenTLSSignatureResult();

            Security.addProvider(new BouncyCastleProvider());
            Reader reader = new CharArrayReader(privStr.toCharArray());
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            PEMParser parser = new PEMParser(reader);
            Object obj = parser.readObject();
            parser.close();
            PrivateKey privKeyStruct = converter.getPrivateKey((PrivateKeyInfo) obj);

            //Create Json string and serialization String
            String jsonString = "{"
                    + "\"TLS.account_type\":\"" + accountType + "\","
                    + "\"TLS.identifier\":\"" + identifier + "\","
                    + "\"TLS.appid_at_3rd\":\"" + strAppid3rd + "\","
                    + "\"TLS.sdk_appid\":\"" + skdAppid + "\","
                    + "\"TLS.expire_after\":\"" + expire + "\""
                    + "}";
            //System.out.println("#jsonString : \n" + jsonString);

            String time = String.valueOf(System.currentTimeMillis() / 1000);
            String SerialString =
                    "TLS.appid_at_3rd:" + strAppid3rd + "\n" +
                            "TLS.account_type:" + accountType + "\n" +
                            "TLS.identifier:" + identifier + "\n" +
                            "TLS.sdk_appid:" + skdAppid + "\n" +
                            "TLS.time:" + time + "\n" +
                            "TLS.expire_after:" + expire + "\n";


            //System.out.println("#SerialString : \n" + SerialString);
            //System.out.println("#SerialString Hex: \n" + Hex.encodeHexString(SerialString.getBytes()));

            try {
                //Create Signature by SerialString
                Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
                signature.initSign(privKeyStruct);
                signature.update(SerialString.getBytes(Charset.forName("UTF-8")));
                byte[] signatureBytes = signature.sign();

                String sigTLS = Base64.getEncoder().encodeToString(signatureBytes);
                //System.out.println("#sigTLS : " + sigTLS);
                //Add TlsSig to jsonString
                Map<String, Object> jsonObject = JSONUtil.toObjectFromString(jsonString, new TypeReference<Map<String, Object>>() {
                });
                jsonObject.put("TLS.sig", (Object) sigTLS);
                jsonObject.put("TLS.time", (Object) time);
                jsonString = jsonObject.toString();

                // System.out.println("#jsonString : \n" + jsonString);

                //compression
                Deflater compresser = new Deflater();
                compresser.setInput(jsonString.getBytes(Charset.forName("UTF-8")));

                compresser.finish();
                byte[] compressBytes = new byte[512];
                int compressBytesLength = compresser.deflate(compressBytes);
                compresser.end();
                //System.out.println("#compressBytes "+ compressBytesLength+": " + Hex.encodeHexString(Arrays.copyOfRange(compressBytes,0,compressBytesLength)));

                //String userSig = Base64.encodeBase64URLSafeString(Arrays.copyOfRange(compressBytes,0,compressBytesLength));
                String userSig = new String(TencentUtil.base64EncodeUrl(Arrays.copyOfRange(compressBytes, 0, compressBytesLength)));

                result.urlSig = userSig;
                //System.out.println("urlSig: "+ userSig);
            } catch (Exception e) {
                e.printStackTrace();
                result.errMessage = "generate usersig failed";
            }

            return result;
        }

        /**
         * @param urlSig      返回 tls 票据
         * @param strAppid3rd 填写与 sdkAppid 一致的字符串形式的值
         * @param skdAppid    应的 appid
         * @param identifier  用户 id
         * @param accountType 创建应用后在配置页面上展示的 acctype
         * @param publicKey   用于校验 tls 票据的公钥内容，但是需要先将公钥文件转换为 java 原生 api 使用的格式，下面是推荐的命令
         *                    openssl pkcs8 -topk8 -in ec_key.pem -outform PEM -out p8_priv.pem -nocrypt
         * @return 如果出错 CheckTLSSignatureResult 中的 verifyResult 为 false，错误信息在 errMsg，校验成功为 true
         * @throws DataFormatException DataFormatException
         * brief 校验 tls 票据
         */
        @Deprecated
        public static CheckTLSSignatureResult CheckTLSSignature(String urlSig,
                                                                String strAppid3rd, long skdAppid,
                                                                String identifier, long accountType,
                                                                String publicKey) throws DataFormatException {
            publicKey = publicKey.replace("\\n", "\n");
            CheckTLSSignatureResult result = new CheckTLSSignatureResult();
            Security.addProvider(new BouncyCastleProvider());

            //DeBaseUrl64 urlSig to json

            //byte [] compressBytes = decoder.decode(urlSig.getBytes());
            byte[] compressBytes = TencentUtil.base64DecodeUrl(urlSig.getBytes(Charset.forName("UTF-8")));

            //System.out.println("#compressBytes Passing in[" + compressBytes.length + "] " + Hex.encodeHexString(compressBytes));

            //Decompression
            Inflater decompression = new Inflater();
            decompression.setInput(compressBytes, 0, compressBytes.length);
            byte[] decompressBytes = new byte[1024];
            int decompressLength = decompression.inflate(decompressBytes);
            decompression.end();

            String jsonString = new String(Arrays.copyOfRange(decompressBytes, 0, decompressLength));

            //System.out.println("#Json String passing in : \n" + jsonString);

            //Get TLS.Sig from json
            Map<String, Object> jsonObject = JSONUtil.toObjectFromString(jsonString, new TypeReference<Map<String, Object>>() {
            });
            String sigTLS = (String) jsonObject.get("TLS.sig");

            //debase64 TLS.Sig to get serailString
            byte[] signatureBytes = Base64.getDecoder().decode(sigTLS.getBytes(Charset.forName("UTF-8")));

            try {

                String sigTime = (String)jsonObject.get("TLS.time");
                String sigExpire = (String) jsonObject.get("TLS.expire_after");

                //checkTime
                //System.out.println("#time check: "+ System.currentTimeMillis()/1000 + "-"
                //+ Long.parseLong(sigTime) + "-" + Long.parseLong(sigExpire));
                if (System.currentTimeMillis() / 1000 - Long.parseLong(sigTime) > Long.parseLong(sigExpire)) {
                    result.errMessage = new String("TLS sig is out of date ");
                    return result;
                }

                //Get Serial String from json
                String SerialString =
                        "TLS.appid_at_3rd:" + strAppid3rd + "\n" +
                                "TLS.account_type:" + accountType + "\n" +
                                "TLS.identifier:" + identifier + "\n" +
                                "TLS.sdk_appid:" + skdAppid + "\n" +
                                "TLS.time:" + sigTime + "\n" +
                                "TLS.expire_after:" + sigExpire + "\n";

                //System.out.println("#SerialString : \n" + SerialString);

                Reader reader = new CharArrayReader(publicKey.toCharArray());
                PEMParser parser = new PEMParser(reader);
                JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
                Object obj = parser.readObject();
                parser.close();
                PublicKey pubKeyStruct = converter.getPublicKey((SubjectPublicKeyInfo) obj);

                Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
                signature.initVerify(pubKeyStruct);
                signature.update(SerialString.getBytes(Charset.forName("UTF-8")));
                boolean bool = signature.verify(signatureBytes);
                //System.out.println("#jdk ecdsa verify : " + bool);
                result.verifyResult = bool;
            } catch (Exception e) {
                e.printStackTrace();
                result.errMessage = "Failed in checking sig";
            }

            return result;
        }

        /**
         * @param skdAppid   应用的 sdkappid
         * @param identifier 用户 id
         * @param privStr    私钥文件内容
         * @return GenTLSSignatureResult
         * @throws IOException IOException
         * brief 生成 tls 票据，精简参数列表，有效期默认为 180 天
         */
        public static GenTLSSignatureResult GenTLSSignatureEx(
                long skdAppid,
                String identifier,
                String privStr) throws IOException {
            return GenTLSSignatureEx(skdAppid, identifier, privStr, 3600 * 24 * 180);
        }

        /**
         * @param skdAppid   应用的 sdkappid
         * @param identifier 用户 id
         * @param privStr    私钥文件内容
         * @param expire     有效期，以秒为单位，推荐时长一个月
         * @return GenTLSSignatureResult
         * @throws IOException IOException
         * brief 生成 tls 票据，精简参数列表
         */
        public static GenTLSSignatureResult GenTLSSignatureEx(
                long skdAppid,
                String identifier,
                String privStr,
                long expire) throws IOException {
            privStr = privStr.replace("\\n", "\n");
            GenTLSSignatureResult result = new GenTLSSignatureResult();

            Security.addProvider(new BouncyCastleProvider());
            Reader reader = new CharArrayReader(privStr.toCharArray());
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            PEMParser parser = new PEMParser(reader);
            Object obj = parser.readObject();
            parser.close();
            PrivateKey privKeyStruct = converter.getPrivateKey((PrivateKeyInfo) obj);

            String jsonString = "{"
                    + "\"TLS.account_type\":\"" + 0 + "\","
                    + "\"TLS.identifier\":\"" + identifier + "\","
                    + "\"TLS.appid_at_3rd\":\"" + 0 + "\","
                    + "\"TLS.sdk_appid\":\"" + skdAppid + "\","
                    + "\"TLS.expire_after\":\"" + expire + "\","
                    + "\"TLS.version\": \"201512300000\""
                    + "}";

            String time = String.valueOf(System.currentTimeMillis() / 1000);
            String SerialString =
                    "TLS.appid_at_3rd:" + 0 + "\n" +
                            "TLS.account_type:" + 0 + "\n" +
                            "TLS.identifier:" + identifier + "\n" +
                            "TLS.sdk_appid:" + skdAppid + "\n" +
                            "TLS.time:" + time + "\n" +
                            "TLS.expire_after:" + expire + "\n";

            try {
                //Create Signature by SerialString
                Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
                signature.initSign(privKeyStruct);
                signature.update(SerialString.getBytes(Charset.forName("UTF-8")));
                byte[] signatureBytes = signature.sign();

                String sigTLS = Base64.getEncoder().encodeToString(signatureBytes);

                //Add TlsSig to jsonString
                Map<String, Object> jsonObject = JSONUtil.toObjectFromString(jsonString, new TypeReference<Map<String, Object>>() {
                });
                jsonObject.put("TLS.sig", (Object) sigTLS);
                jsonObject.put("TLS.time", (Object) time);
                jsonString = jsonObject.toString();

                //compression
                Deflater compresser = new Deflater();
                compresser.setInput(jsonString.getBytes(Charset.forName("UTF-8")));

                compresser.finish();
                byte[] compressBytes = new byte[512];
                int compressBytesLength = compresser.deflate(compressBytes);
                compresser.end();
                String userSig = new String(TencentUtil.base64EncodeUrl(Arrays.copyOfRange(compressBytes, 0, compressBytesLength)));

                result.urlSig = userSig;
            } catch (Exception e) {
                e.printStackTrace();
                result.errMessage = "generate usersig failed";
            }

            return result;
        }

        public static CheckTLSSignatureResult CheckTLSSignatureEx(
                String urlSig,
                long sdkAppid,
                String identifier,
                String publicKey) throws DataFormatException {
            publicKey = publicKey.replace("\\n", "\n");
            CheckTLSSignatureResult result = new CheckTLSSignatureResult();
            Security.addProvider(new BouncyCastleProvider());

            //DeBaseUrl64 urlSig to json

            byte[] compressBytes = TencentUtil.base64DecodeUrl(urlSig.getBytes(Charset.forName("UTF-8")));

            //Decompression
            Inflater decompression = new Inflater();
            decompression.setInput(compressBytes, 0, compressBytes.length);
            byte[] decompressBytes = new byte[1024];
            int decompressLength = decompression.inflate(decompressBytes);
            decompression.end();

            String jsonString = new String(Arrays.copyOfRange(decompressBytes, 0, decompressLength));

            //Get TLS.Sig from json
            Map<String, Object> jsonObject = JSONUtil.toObjectFromString(jsonString, new TypeReference<Map<String, Object>>() {});
            String sigTLS = (String) jsonObject.get("TLS.sig");

            //debase64 TLS.Sig to get serailString
            byte[] signatureBytes = Base64.getDecoder().decode(sigTLS.getBytes(Charset.forName("UTF-8")));

            try {
                String strSdkAppid = (String) jsonObject.get("TLS.sdk_appid");
                String sigTime = (String) jsonObject.get("TLS.time");
                String sigExpire = (String) jsonObject.get("TLS.expire_after");

                if (Integer.parseInt(strSdkAppid) != sdkAppid) {
                    result.errMessage = new String("sdkappid "
                            + strSdkAppid
                            + " in tls sig not equal sdkappid "
                            + sdkAppid
                            + " in request");
                    return result;
                }

                if (System.currentTimeMillis() / 1000 - Long.parseLong(sigTime) > Long.parseLong(sigExpire)) {
                    result.errMessage = new String("TLS sig is out of date");
                    return result;
                }

                //Get Serial String from json
                String SerialString =
                        "TLS.appid_at_3rd:" + 0 + "\n" +
                                "TLS.account_type:" + 0 + "\n" +
                                "TLS.identifier:" + identifier + "\n" +
                                "TLS.sdk_appid:" + sdkAppid + "\n" +
                                "TLS.time:" + sigTime + "\n" +
                                "TLS.expire_after:" + sigExpire + "\n";
                Reader reader = new CharArrayReader(publicKey.toCharArray());
                PEMParser parser = new PEMParser(reader);
                JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
                Object obj = parser.readObject();
                parser.close();
                PublicKey pubKeyStruct = converter.getPublicKey((SubjectPublicKeyInfo) obj);
                Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
                signature.initVerify(pubKeyStruct);
                signature.update(SerialString.getBytes(Charset.forName("UTF-8")));
                boolean bool = signature.verify(signatureBytes);
                result.expireTime = Integer.parseInt(sigExpire);
                result.initTime = Integer.parseInt(sigTime);
                result.verifyResult = bool;
            } catch (Exception e) {
                e.printStackTrace();
                result.errMessage = "Failed in checking sig";
            }

            return result;
        }

    }

    /**
	 * In Yiming-xin.dayukeji.common.util
	 * Create in 18:02 2018/7/23
	 *
	 * @author canfuu
	 * @version v1.0
	 * descriotion 描述
	 */
	public static class DecryptUtil {
		// 算法名称
		final String KEY_ALGORITHM = "AES";

		// 加解密算法/模式/填充方式
		final String algorithmStr = "AES/CBC/PKCS7Padding";
		//
		private Key key;
		private Cipher cipher;

		public void init(byte[] keyBytes) {

			// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
			int base = 16;
			if (keyBytes.length % base != 0) {
				int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
				keyBytes = temp;
			}
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			// 转化成JAVA的密钥格式
			key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
			try {
				// 初始化cipher
				cipher = Cipher.getInstance(algorithmStr);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * 解密方法
         * @param ivStr ivStr
		 * @param encryptedDataStr 要解密的字符串
		 * @param keyBytesStr      解密密钥
         * @throws Exception       Exception
		 * @return 字符串
		 */
		public String decrypt(String encryptedDataStr, String keyBytesStr, String ivStr) throws Exception {
			byte[] encryptedText = null;
			byte[] encryptedData = null;
			byte[] sessionkey = null;
			byte[] iv = null;

			sessionkey = Base64.getDecoder().decode(keyBytesStr);
			encryptedData = Base64.getDecoder().decode(encryptedDataStr);
			iv = Base64.getDecoder().decode(ivStr);

			init(sessionkey);

			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			encryptedText = cipher.doFinal(encryptedData);
			return new String(encryptedText, "utf-8");
		}

		public static void main(String[] args) throws Exception {
			DecryptUtil decryptUtil = new DecryptUtil();
			System.out.println(decryptUtil.decrypt("ses+MkzCtG2AJfdTIXcKCIlDxIY4i6npw0frutzgJJDi8bwmqVV80TzQU3TIwUamx5QORGmYd8UkeJCefj8LzfoZS9Pnu/YdMgwu64eU8zUGp0B36DAeqWgclgN2o/ViONiYm5NKAm7VlgVJCjF5rE3p/iWO7TGGp0yj1nX2M2R40ECU32L/HnfQyz8EfaT8bicgNrRLijcqWHAW2ougmUzmrxG3z/b+cFBglcjaX/mplDDSW/hZaXbZWkKgU4tJ3lyeiLE10K4VwRZmvb3c77kYiXl37WV0n6wT260whLNtXCZqjqeSlE7fATdfNUlVV3uh4Mo7VinYd1WsUOsoSO9/nkvn1Uw0bkRgtbzGvNOyk06xQ72nMJdI8yfAX/fGQrsRwcI7wCpoQ889rQQN029ssRA0ZyfZYefFNGE0OrE4ivM8KP9UtWHrEW5KKHZWnou/dShDA1iTX9D141csKQ==",
					"k7RTzh9dE3rqzT96MxdNlA==", "WXFw7pivWry9P14SRZ8XXw=="));

		}

	}
}
