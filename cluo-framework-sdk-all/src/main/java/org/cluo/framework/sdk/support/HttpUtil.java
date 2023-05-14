package org.cluo.framework.sdk.support;

import org.cluo.framework.json.JSONUtil;

import java.lang.reflect.Method;
import java.util.*;

/**
 * In YunSuDesignWeb-com.yunsudesign.server.common.util
 * Create in 13:18 2018/4/11
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class HttpUtil {

    public static String toUrlString(Object o){
        Map map = JSONUtil.toObjectFromString(JSONUtil.fromObjectAsString(o), Map.class);
        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        StringBuilder content = new StringBuilder();
        list.forEach(entry -> {
            if (content.toString().contains("=")) {
                content.append("&")
                        .append(entry.getKey())
                        .append("=")
                        .append(entry.getValue());
            } else {
                content.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue());
            }
        });

        return content.toString();
    }
}
