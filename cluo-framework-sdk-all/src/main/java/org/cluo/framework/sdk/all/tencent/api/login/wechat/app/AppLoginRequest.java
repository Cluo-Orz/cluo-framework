package org.cluo.framework.sdk.all.tencent.api.login.wechat.app;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.login
 * Create in 18:07 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class AppLoginRequest extends Param<AppLoginRequest> implements Serializable {
    private String appid;
    private String secret;
    private String code;
    private String grant_type = "authorization_code";

    public AppLoginRequest(HttpRequest<AppLoginRequest> request) {
        super(request);
    }

    public String getSecret() {
        return secret;
    }

    public AppLoginRequest setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AppLoginRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public AppLoginRequest setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public AppLoginRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }
}
