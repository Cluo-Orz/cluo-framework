package org.cluo.framework.sdk.all.tencent.api.pay;

import java.io.Serializable;

/**
 * In services-org.cluo.framework.sdk.all.tencent.aggregation.pay
 * Create in 20:40 2018/7/31
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class NotifyResponse implements Serializable {
    private String return_code;
    private String return_msg;

    public String getReturn_code() {
        return return_code;
    }

    public NotifyResponse setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public NotifyResponse setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }
}
