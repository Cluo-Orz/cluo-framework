package org.cluo.framework.sdk.all.tencent.api.pay;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.pay
 * Create in 16:29 2018/9/10
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class TransBankResponse implements Serializable {

	private String return_code;
	private String return_msg;
	private String mchid;
	private String nonce_str;
	private String result_code;
	private String err_code;
	private String err_code_des;
	private String partner_trade_no;
	private String payment_no;
	private String payment_time;
	private String amount;
	private String sign;
	private String cmms_amt;

	public String getReturn_code() {
		return return_code;
	}

	public TransBankResponse setReturn_code(String return_code) {
		this.return_code = return_code;
		return this;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public TransBankResponse setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
		return this;
	}

	public String getMchid() {
		return mchid;
	}

	public TransBankResponse setMchid(String mchid) {
		this.mchid = mchid;
		return this;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public TransBankResponse setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
		return this;
	}

	public String getResult_code() {
		return result_code;
	}

	public TransBankResponse setResult_code(String result_code) {
		this.result_code = result_code;
		return this;
	}

	public String getErr_code() {
		return err_code;
	}

	public TransBankResponse setErr_code(String err_code) {
		this.err_code = err_code;
		return this;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public TransBankResponse setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
		return this;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public TransBankResponse setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
		return this;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public TransBankResponse setPayment_no(String payment_no) {
		this.payment_no = payment_no;
		return this;
	}

	public String getPayment_time() {
		return payment_time;
	}

	public TransBankResponse setPayment_time(String payment_time) {
		this.payment_time = payment_time;
		return this;
	}

	public String getAmount() {
		return amount;
	}

	public TransBankResponse setAmount(String amount) {
		this.amount = amount;
		return this;
	}

	public String getSign() {
		return sign;
	}

	public TransBankResponse setSign(String sign) {
		this.sign = sign;
		return this;
	}

	public String getCmms_amt() {
		return cmms_amt;
	}

	public TransBankResponse setCmms_amt(String cmms_amt) {
		this.cmms_amt = cmms_amt;
		return this;
	}
}
