package org.cluo.framework.sdk.all.tencent.api.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.live
 * Create in 21:49 2018/8/15
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class CommonAccessRequest extends Param<CommonAccessRequest> implements Serializable {
    private Long appid;
    @JsonProperty("interface")
    private String interfaces;
    private Long t;
    private String sign;
    @JsonProperty("Param.s.channel_id")
    private String channelId;

    public CommonAccessRequest(HttpRequest request) {
        super(request);
    }

    public Long getAppid() {
        return appid;
    }

    public CommonAccessRequest setAppid(Long appid) {
        this.appid = appid;
        return this;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public CommonAccessRequest setInterfaces(String interfaces) {
        this.interfaces = interfaces;
        return this;
    }

    public Long getT() {
        return t;
    }

    public CommonAccessRequest setT(Long t) {
        this.t = t;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public CommonAccessRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getChannelId() {
        return channelId;
    }

    public CommonAccessRequest setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }
}
