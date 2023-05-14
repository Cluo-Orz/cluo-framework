package org.cluo.framework.sdk.all.tencent.api.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In yiming--org.cluo.framework.sdk.all.tencent.api.pay
 * Create in 22:55 2018/8/3
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class WechatPayRequest extends Param<WechatPayRequest> implements Serializable {
    private String appid;
    private String appId;
    private String partnerid;
    private String prepayid;
    @JsonProperty("package")
    private String packages;
    private String nonceStr;
    private String noncestr;
    private String timestamp;
    private String timeStamp;
    private String sign;
    private String signType;
    private String code;
    private String paySign;
    private String codeUrl;
    private Boolean pay;
    public WechatPayRequest(){
        super(null);
    }
    public WechatPayRequest(HttpRequest request) {
        super(request);
    }

    public String getPaySign() {
        return paySign;
    }

    public WechatPayRequest setPaySign(String paySign) {
        this.paySign = paySign;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public WechatPayRequest setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public WechatPayRequest setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public WechatPayRequest setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public String getSignType() {
        return signType;
    }

    public WechatPayRequest setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public String getCode() {
        return code;
    }

    public WechatPayRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public WechatPayRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public WechatPayRequest setPartnerid(String partnerid) {
        this.partnerid = partnerid;
        return this;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public WechatPayRequest setPrepayid(String prepayid) {
        this.prepayid = prepayid;
        return this;
    }

    public String getPackages() {
        return packages;
    }

    public WechatPayRequest setPackages(String packages) {
        this.packages = packages;
        return this;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public WechatPayRequest setNoncestr(String noncestr) {
        this.noncestr = noncestr;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public WechatPayRequest setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WechatPayRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public WechatPayRequest setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
        return this;
    }

    public Boolean isPay() {
        return pay;
    }

    public WechatPayRequest setPay(Boolean pay) {
        this.pay = pay;
        return this;
    }
}
