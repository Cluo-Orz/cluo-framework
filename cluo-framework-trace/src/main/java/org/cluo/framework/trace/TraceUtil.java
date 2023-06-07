package org.cluo.framework.trace;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author canfuu.cts
 * @class TraceUtil
 * @date 2023/5/14 17:55
 */
public class TraceUtil {

    private static Pattern pattern = Pattern.compile("-");

    private static final ThreadLocal<String> traceId = new ThreadLocal<>(){
        @Override
        protected String initialValue() {
            return pattern.matcher(UUID.randomUUID().toString()).replaceAll("");
        }
    };

    public static String getTraceId() {
        return traceId.get();
    }

    public static String getTraceIdForLog() {
        return "[" + traceId.get() + "] ";
    }

    public static void removeTraceId() {
        traceId.remove();
    }
}
