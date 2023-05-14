package org.cluo.framework.sdk.all.tencent.api.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity
 * Create in 15:11 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class BaseRequest<T extends Param<T>> extends Param<T> {
    @JsonProperty("Action")
    protected Action action;
    @JsonProperty("Region")
    protected String region;
    @JsonProperty("Timestamp")
    protected Long timestamp;
    @JsonProperty("Nonce")
    protected Integer nonce;
    @JsonProperty("SecretId")
    protected String secretId;
    @JsonProperty("Signature")
    protected String signature;
    @JsonProperty("SignatureMethod")
    protected String signatureMethod;
    @JsonProperty("Version")
    protected String version;

    public BaseRequest(HttpRequest<T> request) {
        super(request);
    }

    public String getVersion() {
        return version;
    }

    public BaseRequest<T> setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getSignatureMethod() {
        return signatureMethod;
    }

    public BaseRequest setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
        return this;
    }

    public BaseRequest setSignatureMethod(Object signatureMethod) {
        this.signatureMethod = String.valueOf(signatureMethod);
        return this;
    }

    public Action getAction() {
        return action;
    }

    public BaseRequest setAction(Action action) {
        this.action = action;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public BaseRequest setRegion(Region region) {
        this.region = String.valueOf(region);
        return this;
    }

    public BaseRequest setRegion(String region) {
        this.region = region;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public BaseRequest setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getNonce() {
        return nonce;
    }

    public BaseRequest setNonce(Integer nonce) {
        this.nonce = nonce;
        return this;
    }

    public String getSecretId() {
        return secretId;
    }

    public BaseRequest setSecretId(String secretId) {
        this.secretId = secretId;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public BaseRequest setSignature(String signature) {
        this.signature = signature;
        return this;
    }

}
