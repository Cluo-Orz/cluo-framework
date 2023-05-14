package org.cluo.framework.sdk.all.tencent.api.login.wechat.mini;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * In Yiming--xin.dayukeji.yiming.function.user.controller.api
 * Create in 20:43 2018/7/22
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class MiniCheckRequest implements Serializable {
    protected String code;
    protected String path;
    protected Auth auth;

    public static class Auth implements Serializable {
        private String unionId;
        @JsonProperty("iv")
        private String iv;
        private String encryptedData;

        public String getEncryptedData() {
            return encryptedData;
        }

        public void setEncryptedData(String encryptedData) {
            this.encryptedData = encryptedData;
        }

        public String getIv() {
            return iv;
        }

        public Auth setIv(String iv) {
            this.iv = iv;
            return this;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

    }

    public Auth getAuth() {
        return auth;
    }

    public MiniCheckRequest setAuth(Auth auth) {
        this.auth = auth;
        return this;
    }

    public String getCode() {
        return code;
    }

    public MiniCheckRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getPath() {
        return path;
    }

    public MiniCheckRequest setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MiniCheckRequest{");
        sb.append("code='").append(code).append('\'');
        sb.append(", auth=").append(auth);
        sb.append('}');
        return sb.toString();
    }
}
