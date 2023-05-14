package org.cluo.framework.sdk.all.tencent.api.pay;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.aggregation.pay
 * Create in 20:32 2018/7/31
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class OrderQueryResponse implements Serializable {
    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_msg;
    private String err_code_des;
    private String device_info;
    private String openid;
    private String is_subscribe;
    private String trade_type;
    private String trade_state;
    private String bank_type;
    private Integer total_fee;
    private Integer settiement_total_fee;
    private String fee_type;
    private Integer cash_fee;
    private String cash_fee_type;
    private Integer coupon_fee;
    private Integer coupon_count;
    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;
    private String trade_state_desc;

    public String getReturn_code() {
        return return_code;
    }

    public OrderQueryResponse setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public OrderQueryResponse setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public OrderQueryResponse setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public OrderQueryResponse setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public OrderQueryResponse setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public OrderQueryResponse setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderQueryResponse setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public OrderQueryResponse setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public OrderQueryResponse setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_msg() {
        return err_code_msg;
    }

    public OrderQueryResponse setErr_code_msg(String err_code_msg) {
        this.err_code_msg = err_code_msg;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public OrderQueryResponse setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public OrderQueryResponse setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public OrderQueryResponse setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public OrderQueryResponse setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public OrderQueryResponse setTrade_state(String trade_state) {
        this.trade_state = trade_state;
        return this;
    }

    public String getBank_type() {
        return bank_type;
    }

    public OrderQueryResponse setBank_type(String bank_type) {
        this.bank_type = bank_type;
        return this;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public OrderQueryResponse setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public Integer getSettiement_total_fee() {
        return settiement_total_fee;
    }

    public OrderQueryResponse setSettiement_total_fee(Integer settiement_total_fee) {
        this.settiement_total_fee = settiement_total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public OrderQueryResponse setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public Integer getCash_fee() {
        return cash_fee;
    }

    public OrderQueryResponse setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public OrderQueryResponse setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
        return this;
    }

    public Integer getCoupon_fee() {
        return coupon_fee;
    }

    public OrderQueryResponse setCoupon_fee(Integer coupon_fee) {
        this.coupon_fee = coupon_fee;
        return this;
    }

    public Integer getCoupon_count() {
        return coupon_count;
    }

    public OrderQueryResponse setCoupon_count(Integer coupon_count) {
        this.coupon_count = coupon_count;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public OrderQueryResponse setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public OrderQueryResponse setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public OrderQueryResponse setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTime_end() {
        return time_end;
    }

    public OrderQueryResponse setTime_end(String time_end) {
        this.time_end = time_end;
        return this;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    public OrderQueryResponse setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
        return this;
    }
}
