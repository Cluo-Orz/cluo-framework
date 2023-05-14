package org.cluo.framework.sdk.support;

import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

/**
 * In server-com.dayukeji.common.utils
 * <p>
 * Create in 16:33 2017/12/10
 *
 * @author canfuu
 * @version v1.0:say explain
 */
public class CodeUtil {
    public static final String SOURCES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public static final String NUMBERS = "1234567890";

    public static final Long decode36C(String imIdentify) {
        Long result = Long.valueOf(imIdentify, 36);
        return result == null ? 0L : result;
    }

    public static final String encode36C(Long userId) {
        return Long.toString(userId, 36);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getRandom(int number) {
        long max = ((Double) Math.pow(10, (double) number)).longValue() - 1;
        long min = ((Double) Math.pow(10, (double) number - 1)).longValue();
        Random r = new Random();
        long s = r.nextLong();
        while (s < min) {
            s *= 10;
        }
        while (s > max) {
            s /= 10;
        }
        return s + "";
    }

    public static String getNumberRandom(int length) {
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(random.nextInt(10));
        }
        return s.toString();
    }

    public static String generateString(int number) {
        Random r = new Random();
        char[] text = new char[number];
        for (int i = 0; i < number; i++) {
            text[i] = SOURCES.charAt(r.nextInt(SOURCES.length()));
        }
        return new String(text);
    }

    public static String encodeByBase64(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
    public static String decodeByBase64(String base64){
        return new String(Base64.getDecoder().decode(base64));
    }

    public static byte[] encodeByBase64Byte(String data){
        return Base64.getEncoder().encode(data.getBytes());
    }
    public static String decodeByBase64Byte(byte[] base64){
        return new String(Base64.getEncoder().encode(base64));
    }

    public static String encodeByMD5(String message) {
        return DigestUtils.md5DigestAsHex(message.getBytes());
    }
    public static String encodeByMD5(byte[] message) {
        return DigestUtils.md5DigestAsHex(message);
    }
    public static boolean checkByMD5(String message,String md5) {
        return encodeByMD5(message).equals(md5);
    }

    public static enum SecretType implements Serializable {
        HmacSHA1, HmacSHA256
    }
    public static String encodeByAES(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getAESSecretKey(password));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return Base64.getEncoder().encodeToString(result);//通过Base64转码返回
        } catch (Exception ex) {
        }

        return null;
    }

    public static String decodeByAES(String content, String password) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getAESSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));

            return new String(result, "utf-8");
        } catch (Exception ex) {
        }

        return null;
    }

    public static SecretKeySpec getAESSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;

        try {
            kg = KeyGenerator.getInstance("AES");

            //AES 要求密钥长度为 128
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kg.init(128, random);

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), "AES");// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
        }

        return null;
    }

    public static boolean chechBySHA(String sha,String data, String secret, SecretType secretType){
        return sha.equals(encodeBySHA(data, secret, secretType));
    }
    public static String encodeBySHA(String data, String secret, SecretType secretType) {
        byte[] secretRes = encodeBySHASource(data, secret, secretType);
        if(secretRes!=null) {
            return Base64.getEncoder().encodeToString(secretRes);
        }else {
            return null;
        }
    }
    public static byte[] encodeBySHASource(String data, String secret, SecretType secretType) {
        try {
            Mac sha256Hmac = Mac.getInstance(secretType.toString());
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), secretType.toString());
            sha256Hmac.init(secretKeySpec);
            byte[] b = sha256Hmac.doFinal(data.getBytes());
            return b;
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return null;
        }
    }

    public static String subString(String s, Integer start, Integer end){
        return s.substring(start, end);
    }

    public static boolean isEmpty(String string){
        if (string == null || string.equals(""))
            return true;

        return false;
    }

    /**
     * 将富文本的标签去除，并返回概览信息
     * @param content 需要操作的内容
     * @param length 指定返回的长度
     * @param min 如果文本小于指定长度。
     * @return 概览信息
     */
    public String getRichTextOverview(String content, Integer length, Integer min) {
        String substring = content;
        if (content.length() >= length)
            substring = content.substring(0, length);
        String s = substring
                .replaceAll("</?[^>]+>", "")
                .replaceAll("&lt;", "")
                .replaceAll("&nbsp;", "");
        return s.length() < min ? s : s + "...";
    }

    public String getRichTextOverview(String content){
        return getRichTextOverview(content, 400, 100);
    }

    public String getRichTextOverview(String content, Integer length){
        return getRichTextOverview(content, length, 100);
    }
}
