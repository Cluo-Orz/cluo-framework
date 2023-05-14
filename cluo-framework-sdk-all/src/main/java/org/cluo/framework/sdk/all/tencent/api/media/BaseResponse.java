package org.cluo.framework.sdk.all.tencent.api.media;

import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity
 * Create in 15:15 2018/7/13
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class BaseResponse implements Serializable {
    protected Integer code;
    protected String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
