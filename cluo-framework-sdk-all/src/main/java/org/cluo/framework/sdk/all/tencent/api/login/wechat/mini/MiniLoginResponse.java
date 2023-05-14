package org.cluo.framework.sdk.all.tencent.api.login.wechat.mini;


import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.login
 * Create in 20:57 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class MiniLoginResponse implements Serializable {
    private String openid;
    private String session_key;
    private String unionid;
    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getOpenid() {
        return openid;
    }

    public MiniLoginResponse setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getSession_key() {
        return session_key;
    }

    public MiniLoginResponse setSession_key(String session_key) {
        this.session_key = session_key;
        return this;
    }

    public String getUnionid() {
        return unionid;
    }

    public MiniLoginResponse setUnionid(String unionid) {
        this.unionid = unionid;
        return this;
    }


}
