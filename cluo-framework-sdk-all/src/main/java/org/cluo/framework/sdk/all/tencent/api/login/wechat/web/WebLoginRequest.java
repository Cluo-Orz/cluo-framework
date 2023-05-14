package org.cluo.framework.sdk.all.tencent.api.login.wechat.web;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 *
 * Create in 20:47 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 微信网页扫码登录功能，获取用户信息的封装类
 */
public class WebLoginRequest extends Param<WebLoginRequest> implements Serializable {
    private String appid;
    private String secret;
    private String code;
    private String grant_type = "authorization_code";

    public WebLoginRequest(HttpRequest<WebLoginRequest> request) {
        super(request);
    }

    public String getAppid() {
        return appid;
    }

    public WebLoginRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public WebLoginRequest setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getCode() {
        return code;
    }

    public WebLoginRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public WebLoginRequest setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }
}
