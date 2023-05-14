package org.cluo.framework.sdk.all.tencent.api.media;

import java.io.Serializable;

/**
 * In yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity
 * Create in 11:26 2018/7/20
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class VodUploadSignature implements Serializable {
    private String secretId;
    /**
     * 单位 秒
     */
    private Integer currentTimeStamp;
    /**
     * 单位 秒
     */
    private Integer expireTime;
    private Integer random;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public Integer getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(Integer currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "secretId=" + secretId + "&currentTimeStamp=" + currentTimeStamp + "&expireTime=" + expireTime + "&random=" + random;
    }
}
