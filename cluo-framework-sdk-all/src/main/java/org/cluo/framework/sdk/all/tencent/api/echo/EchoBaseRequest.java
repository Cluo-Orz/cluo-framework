package org.cluo.framework.sdk.all.tencent.api.echo;

import org.cluo.framework.json.JSONUtil;
import org.cluo.framework.sdk.all.tencent.enums.EventType;

import java.io.Serializable;
import java.util.Map;

/**
 * In Yiming-org.cluo.framework.sdk.support.tencent
 * Create in 13:14 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class EchoBaseRequest<T> implements Serializable {
    protected String version;
    protected EventType eventType;
    protected T data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static EchoBaseRequest newInstance(Map<String, Object> map) {
        if (map != null && map.get("eventType") != null) {
            String json = JSONUtil.fromObjectAsString(map);
            String eventType = (String) map.get("eventType");//
            try {
                EventType type = EventType.valueOf(eventType);
                Class<EchoBaseRequest> request = (Class<EchoBaseRequest>) Class.forName("org.cluo.framework.sdk.all.tencent.api.echo.api." + type + ".Request");
                return JSONUtil.toObjectFromString(json, request);
            } catch (Exception e) {
            }
        }
        return null;
    }
}
