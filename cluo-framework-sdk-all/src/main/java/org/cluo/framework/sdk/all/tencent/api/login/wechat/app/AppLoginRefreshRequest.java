package org.cluo.framework.sdk.all.tencent.api.login.wechat.app;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.login
 * Create in 19:42 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class AppLoginRefreshRequest extends Param<AppLoginRefreshRequest> implements Serializable {
    private String appid;
    private String grant_type = "refresh_token";
    private String refresh_token;

    public AppLoginRefreshRequest(HttpRequest<AppLoginRefreshRequest> request) {
        super(request);
    }

    public String getAppid() {
        return appid;
    }

    public AppLoginRefreshRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public AppLoginRefreshRequest setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public AppLoginRefreshRequest setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }
}
