package org.cluo.framework.sdk.all.tencent.api.mp;


import java.io.Serializable;

public class OpenidResponse implements Serializable {
    private Integer errcode;

    private String errmsg;

    private String access_token;

    private Integer expires_in;

    private String refresh_token;

    private String openid;

    private String scope;

    public Integer getErrcode() {
        return errcode;
    }

    public OpenidResponse setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public OpenidResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public OpenidResponse setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public OpenidResponse setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public OpenidResponse setScope(String scope) {
        this.scope = scope;
        return this;
    }

    @Override
    public String toString() {
        return "OpenidResponse{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
