package org.cluo.framework.sdk.all.tencent.api.pay;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

public class RefundRequest extends Param<RefundRequest> implements Serializable {
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String out_trade_no;
    private String out_refund_no;
    private Integer total_fee;
    private Integer refund_fee;
    private String notify_url;
    private String refund_desc; //退款原因

    public RefundRequest(HttpRequest<RefundRequest> request) {
        super(request);
    }

    public String getAppid() {
        return appid;
    }

    public RefundRequest setAppid(String appid) {
        this.appid = appid;
        return this;

    }

    public String getMch_id() {
        return mch_id;
    }

    public RefundRequest setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public RefundRequest setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public RefundRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public RefundRequest setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public RefundRequest setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public RefundRequest setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public RefundRequest setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public Integer getRefund_fee() {
        return refund_fee;
    }

    public RefundRequest setRefund_fee(Integer refund_fee) {
        this.refund_fee = refund_fee;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public RefundRequest setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public String getRefund_desc() {
        return refund_desc;
    }

    public RefundRequest setRefund_desc(String refund_desc) {
        this.refund_desc = refund_desc;
        return this;
    }

    @Override
    public String toString() {
        return "RefundRequest{" +
                "appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", sign='" + sign + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", out_refund_no='" + out_refund_no + '\'' +
                ", total_fee=" + total_fee +
                ", refund_fee=" + refund_fee +
                ", notify_url='" + notify_url + '\'' +
                ", refund_desc='" + refund_desc + '\'' +
                '}';
    }
}
