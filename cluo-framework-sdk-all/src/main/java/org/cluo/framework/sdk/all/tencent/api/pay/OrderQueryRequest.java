package org.cluo.framework.sdk.all.tencent.api.pay;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services-org.cluo.framework.sdk.all.tencent.aggregation.pay
 * Create in 20:29 2018/7/31
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class OrderQueryRequest extends Param<OrderQueryRequest> implements Serializable {
    private String appid;
    private String mch_id;
    private String transaction_id;
    private String out_trade_no;
    private String nonce_str;
    private String sign;
    private String sign_type;

    public OrderQueryRequest(HttpRequest<OrderQueryRequest> request) {
        super(request);
    }

    public String getAppid() {
        return appid;
    }

    public OrderQueryRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public OrderQueryRequest setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public OrderQueryRequest setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public OrderQueryRequest setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public OrderQueryRequest setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderQueryRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public OrderQueryRequest setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }
}
