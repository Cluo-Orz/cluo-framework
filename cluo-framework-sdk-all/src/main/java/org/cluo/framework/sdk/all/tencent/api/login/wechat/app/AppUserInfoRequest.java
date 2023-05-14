package org.cluo.framework.sdk.all.tencent.api.login.wechat.app;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.login
 * Create in 19:46 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class AppUserInfoRequest extends Param<AppUserInfoRequest> implements Serializable {
    private String access_token;
    private String openid;
    private String lang;

    public AppUserInfoRequest(HttpRequest<AppUserInfoRequest> request) {
        super(request);
    }

    public String getAccess_token() {
        return access_token;
    }

    public AppUserInfoRequest setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public AppUserInfoRequest setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public AppUserInfoRequest setLang(String lang) {
        this.lang = lang;
        return this;
    }
}
