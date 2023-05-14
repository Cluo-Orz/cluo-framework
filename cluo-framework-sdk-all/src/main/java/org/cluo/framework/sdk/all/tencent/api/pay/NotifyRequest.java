package org.cluo.framework.sdk.all.tencent.api.pay;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * In services-org.cluo.framework.sdk.all.tencent.aggregation.pay
 * Create in 20:39 2018/7/31
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class NotifyRequest implements Serializable {
    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String openid;
    private String is_subscribe;
    private String sub_mch_id;
    private String trade_type;
    private String bank_type;
    private Integer total_fee;
    private Integer settlement_total_fee;
    private String fee_type;
    private Integer cash_fee;
    private String cash_fee_type;
    private String coupon_type;
    private String coupon_id;
    private Integer coupon_fee;
    private Integer coupon_count;
    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;
    @JsonIgnore
    public boolean isRight(){
        return Objects.equals(result_code, "SUCCESS") && Objects.equals(return_code, "SUCCESS");
    }
    public String getReturn_code() {
        return return_code;
    }

    public NotifyRequest setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public NotifyRequest setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public NotifyRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public NotifyRequest setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public NotifyRequest setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getCoupon_type() {
        return coupon_type;
    }

    public NotifyRequest setCoupon_type(String coupon_type) {
        this.coupon_type = coupon_type;
        return this;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public NotifyRequest setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public NotifyRequest setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public NotifyRequest setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public NotifyRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public NotifyRequest setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public NotifyRequest setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public NotifyRequest setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public NotifyRequest setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public NotifyRequest setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public NotifyRequest setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public NotifyRequest setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getBank_type() {
        return bank_type;
    }

    public NotifyRequest setBank_type(String bank_type) {
        this.bank_type = bank_type;
        return this;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public NotifyRequest setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public Integer getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public NotifyRequest setSettlement_total_fee(Integer settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public NotifyRequest setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public Integer getCash_fee() {
        return cash_fee;
    }

    public NotifyRequest setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public NotifyRequest setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
        return this;
    }

    public Integer getCoupon_fee() {
        return coupon_fee;
    }

    public NotifyRequest setCoupon_fee(Integer coupon_fee) {
        this.coupon_fee = coupon_fee;
        return this;
    }

    public Integer getCoupon_count() {
        return coupon_count;
    }

    public NotifyRequest setCoupon_count(Integer coupon_count) {
        this.coupon_count = coupon_count;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public NotifyRequest setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public NotifyRequest setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public NotifyRequest setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTime_end() {
        return time_end;
    }

    public NotifyRequest setTime_end(String time_end) {
        this.time_end = time_end;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NotifyRequest{");
        sb.append("return_code='").append(return_code).append('\'');
        sb.append(", return_msg='").append(return_msg).append('\'');
        sb.append(", appid='").append(appid).append('\'');
        sb.append(", mch_id='").append(mch_id).append('\'');
        sb.append(", device_info='").append(device_info).append('\'');
        sb.append(", nonce_str='").append(nonce_str).append('\'');
        sb.append(", sign='").append(sign).append('\'');
        sb.append(", sign_type='").append(sign_type).append('\'');
        sb.append(", result_code='").append(result_code).append('\'');
        sb.append(", err_code='").append(err_code).append('\'');
        sb.append(", err_code_des='").append(err_code_des).append('\'');
        sb.append(", openid='").append(openid).append('\'');
        sb.append(", is_subscribe='").append(is_subscribe).append('\'');
        sb.append(", trade_type='").append(trade_type).append('\'');
        sb.append(", bank_type='").append(bank_type).append('\'');
        sb.append(", total_fee=").append(total_fee);
        sb.append(", settlement_total_fee=").append(settlement_total_fee);
        sb.append(", fee_type='").append(fee_type).append('\'');
        sb.append(", cash_fee=").append(cash_fee);
        sb.append(", cash_fee_type='").append(cash_fee_type).append('\'');
        sb.append(", coupon_fee=").append(coupon_fee);
        sb.append(", coupon_count=").append(coupon_count);
        sb.append(", transaction_id='").append(transaction_id).append('\'');
        sb.append(", out_trade_no='").append(out_trade_no).append('\'');
        sb.append(", attach='").append(attach).append('\'');
        sb.append(", time_end='").append(time_end).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
