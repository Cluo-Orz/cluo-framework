package org.cluo.framework.sdk.all.tencent.api.login.wechat.mini;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.login
 * Create in 20:47 2018/7/22
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class MiniLoginRequest extends Param<MiniLoginRequest> implements Serializable {
    private String appid;
    private String secret;
    private String js_code;
    private String grant_type = "authorization_code";

    public MiniLoginRequest(HttpRequest<MiniLoginRequest> request) {
        super(request);
    }

    public String getAppid() {
        return appid;
    }

    public MiniLoginRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public MiniLoginRequest setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getJs_code() {
        return js_code;
    }

    public MiniLoginRequest setJs_code(String js_code) {
        this.js_code = js_code;
        return this;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public MiniLoginRequest setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }
}
