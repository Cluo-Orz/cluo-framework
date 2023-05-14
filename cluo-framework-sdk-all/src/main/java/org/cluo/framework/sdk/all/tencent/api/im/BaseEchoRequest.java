package org.cluo.framework.sdk.all.tencent.api.im;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api
 * Create in 18:06 2018/8/15
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class BaseEchoRequest implements Serializable {
    private Long SdkAppid;
    private String CallbackCommand;
    private String contenttype;
    private String ClientIP;
    private String OptPlatform;

    public Long getSdkAppid() {
        return SdkAppid;
    }

    public BaseEchoRequest setSdkAppid(Long sdkAppid) {
        SdkAppid = sdkAppid;
        return this;
    }

    public String getCallbackCommand() {
        return CallbackCommand;
    }

    public BaseEchoRequest setCallbackCommand(String callbackCommand) {
        CallbackCommand = callbackCommand;
        return this;
    }

    public String getContenttype() {
        return contenttype;
    }

    public BaseEchoRequest setContenttype(String contenttype) {
        this.contenttype = contenttype;
        return this;
    }

    public String getClientIP() {
        return ClientIP;
    }

    public BaseEchoRequest setClientIP(String clientIP) {
        ClientIP = clientIP;
        return this;
    }

    public String getOptPlatform() {
        return OptPlatform;
    }

    public BaseEchoRequest setOptPlatform(String optPlatform) {
        OptPlatform = optPlatform;
        return this;
    }
}
