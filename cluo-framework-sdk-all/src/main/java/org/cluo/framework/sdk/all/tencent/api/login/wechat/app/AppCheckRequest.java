package org.cluo.framework.sdk.all.tencent.api.login.wechat.app;

import java.io.Serializable;

/**
 * In Yiming--xin.dayukeji.yiming.function.user.controller.api
 * Create in 20:12 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class AppCheckRequest implements Serializable {
    protected String openid;
    protected String token;

    public AppCheckRequest setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public String getToken() {
        return token;
    }

    public AppCheckRequest setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AppCheckRequest{");
        sb.append("openid='").append(openid).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
