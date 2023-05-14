package org.cluo.framework.sdk.all.tencent.api.login.qq;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.login.qq
 * Create in 01:05 2018/8/17
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class QQCheckResponse {
    private Integer error;
    private String error_description;
    private String client_id;
    private String openid;
    private String unionid;

    public Integer getError() {
        return error;
    }

    public QQCheckResponse setError(Integer error) {
        this.error = error;
        return this;
    }

    public String getError_description() {
        return error_description;
    }

    public QQCheckResponse setError_description(String error_description) {
        this.error_description = error_description;
        return this;
    }

    public String getClient_id() {
        return client_id;
    }

    public QQCheckResponse setClient_id(String client_id) {
        this.client_id = client_id;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public QQCheckResponse setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getUnionid() {
        return unionid;
    }

    public QQCheckResponse setUnionid(String unionid) {
        this.unionid = unionid;
        return this;
    }
}
