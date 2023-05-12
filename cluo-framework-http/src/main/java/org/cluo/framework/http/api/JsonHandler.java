package org.cluo.framework.http.api;

/**
 * @author canfuu.cts
 * @class JsonHandler
 * @date 2023/5/13 00:21
 */
public interface JsonHandler {

    String toJsonString(Object object);

    <T> T toObject(String json, Class<T> clazz);
}