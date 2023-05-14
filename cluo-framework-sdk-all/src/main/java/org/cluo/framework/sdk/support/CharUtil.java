package org.cluo.framework.sdk.support;

/**
 * @author canfuu.cts
 * @class CharUtil
 * @date 2023/5/13 11:04
 */
public class CharUtil {
    /**
     * 移除目标字符串中的最后一个字符
     * @param s 操作字符串
     * @return 字符串
     */
    public static String removeLastChar(String s){
        if(s==null){
            return null;
        }
        StringBuilder sb = new StringBuilder(s);
        return removeLastChar(sb);
    }
    /**
     * 移除目标字符串中的最后一个字符
     * @param sb 操作字符串
     * @return 处理后的字符串
     */
    public static String removeLastChar(StringBuilder sb){
        if(sb==null){
            return null;
        }
        int len = sb.length();
        sb.delete(len-1,len);
        return sb.toString();
    }

}
