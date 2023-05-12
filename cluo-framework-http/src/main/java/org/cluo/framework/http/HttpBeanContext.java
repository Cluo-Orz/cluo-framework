package org.cluo.framework.http;

import org.cluo.framework.http.api.HttpLogHandler;
import org.cluo.framework.http.api.JsonHandler;

/**
 * @author canfuu.cts
 * @class HttpBeanContext
 * @date 2023/5/13 00:23
 */
public class HttpBeanContext {
    protected static HttpLogHandler logger = null;

    protected static JsonHandler jsonHandler = null;

    public static void init(
            HttpLogHandler httpLogHandler,
            JsonHandler jsonHandler
    ) {
        if(HttpBeanContext.logger !=null){
            throw new HttpException("httpLogHandler already set");
        }
        HttpBeanContext.logger = httpLogHandler;
        HttpBeanContext.jsonHandler = jsonHandler;
    }
}
