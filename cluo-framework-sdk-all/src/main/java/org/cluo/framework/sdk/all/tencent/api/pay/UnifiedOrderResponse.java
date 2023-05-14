package org.cluo.framework.sdk.all.tencent.api.pay;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.aggregation.pay
 * Create in 20:21 2018/7/31
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class UnifiedOrderResponse implements Serializable {
    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String trade_type;
    private String prepay_id;
    private String mweb_url;
    private String code_url;

    public String getReturn_code() {
        return return_code;
    }

    public UnifiedOrderResponse setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public UnifiedOrderResponse setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public UnifiedOrderResponse setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public UnifiedOrderResponse setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public UnifiedOrderResponse setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public UnifiedOrderResponse setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public UnifiedOrderResponse setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public UnifiedOrderResponse setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public UnifiedOrderResponse setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public UnifiedOrderResponse setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public UnifiedOrderResponse setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public UnifiedOrderResponse setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
        return this;
    }

    public String getMweb_url() {
        return mweb_url;
    }

    public UnifiedOrderResponse setMweb_url(String mweb_url) {
        this.mweb_url = mweb_url;
        return this;
    }

    public String getCode_url() {
        return code_url;
    }

    public UnifiedOrderResponse setCode_url(String code_url) {
        this.code_url = code_url;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UnifiedOrderResponse{");
        sb.append("return_code='").append(return_code).append('\'');
        sb.append(", return_msg='").append(return_msg).append('\'');
        sb.append(", appid='").append(appid).append('\'');
        sb.append(", mch_id='").append(mch_id).append('\'');
        sb.append(", device_info='").append(device_info).append('\'');
        sb.append(", nonce_str='").append(nonce_str).append('\'');
        sb.append(", sign='").append(sign).append('\'');
        sb.append(", result_code='").append(result_code).append('\'');
        sb.append(", err_code='").append(err_code).append('\'');
        sb.append(", err_code_des='").append(err_code_des).append('\'');
        sb.append(", trade_type='").append(trade_type).append('\'');
        sb.append(", prepay_id='").append(prepay_id).append('\'');
        sb.append(", mweb_url='").append(mweb_url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
