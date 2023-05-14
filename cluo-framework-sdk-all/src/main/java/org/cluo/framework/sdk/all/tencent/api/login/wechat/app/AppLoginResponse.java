package org.cluo.framework.sdk.all.tencent.api.login.wechat.app;

import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.login
 * Create in 19:31 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class AppLoginResponse implements Serializable {
    private String access_token;
    private Long expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private Long errcode;
    private String errmsg;

    public Long getErrcode() {
        return errcode;
    }

    public void setErrcode(Long errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
