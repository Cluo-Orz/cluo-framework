package org.cluo.framework.sdk.all.tencent.api.login.qq;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * ClassName QQUserInfoRequest
 * Description TODO
 * Author zhangfg
 * Date 2019-06-25 11:56
 * Version 1.0
 */
public class QQUserInfoRequest extends Param<QQUserInfoRequest> implements Serializable {
    private String access_token;
    //申请QQ登录成功后，分配给应用的appid
    private String oauth_consumer_key;
    private String openid;

    public QQUserInfoRequest(HttpRequest<QQUserInfoRequest> request) {
        super(request);
    }

    public String getAccess_token() {
        return access_token;
    }

    public QQUserInfoRequest setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getOauth_consumer_key() {
        return oauth_consumer_key;
    }

    public QQUserInfoRequest setOauth_consumer_key(String oauth_consumer_key) {
        this.oauth_consumer_key = oauth_consumer_key;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public QQUserInfoRequest setOpenid(String openid) {
        this.openid = openid;
        return this;
    }
}
