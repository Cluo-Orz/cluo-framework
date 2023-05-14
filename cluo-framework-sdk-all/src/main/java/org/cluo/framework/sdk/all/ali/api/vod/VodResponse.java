package org.cluo.framework.sdk.all.ali.api.vod;



import java.io.Serializable;

/**
 * author: yfy
 * date: 2019-03-07 10:27
 * version 1.0
 * description 描述
 */
public class VodResponse  implements Serializable {
    private String accessKeyId;
    private String accessKeySecret;
    private String region;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
