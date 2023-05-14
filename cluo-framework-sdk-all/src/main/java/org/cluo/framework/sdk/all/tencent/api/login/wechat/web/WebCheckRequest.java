package org.cluo.framework.sdk.all.tencent.api.login.wechat.web;


import java.io.Serializable;

/**
 * In Yiming--xin.dayukeji.yiming.function.user.controller.api
 * Create in 20:43 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class WebCheckRequest implements Serializable {
    protected String code;

    public String getCode() {
        return code;
    }

    public WebCheckRequest setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MiniCheckRequest{");
        sb.append("code='").append(code).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
