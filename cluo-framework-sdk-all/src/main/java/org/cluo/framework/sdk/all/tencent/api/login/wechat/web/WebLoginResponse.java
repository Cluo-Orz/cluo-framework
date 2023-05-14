package org.cluo.framework.sdk.all.tencent.api.login.wechat.web;


import java.io.Serializable;

/**
 * In yiming--org.cluo.framework.sdk.all.tencent.api.login
 * Create in 15:42 2018/8/8
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class WebLoginResponse implements Serializable {
    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private Integer errcode;
    private String errmsg;

    public String getAccess_token() {
        return access_token;
    }

    public WebLoginResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public WebLoginResponse setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public WebLoginResponse setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public WebLoginResponse setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public WebLoginResponse setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public WebLoginResponse setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public WebLoginResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }
}
