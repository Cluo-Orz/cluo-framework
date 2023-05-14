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
public class TransfersResponse implements Serializable {

	private String return_code;
	private String return_msg;
	private String mch_appid;
	private String mchid;
	private String nonce_str;
	private String result_code;
	private String err_code;
	private String err_code_des;
	private String partner_trade_no;
	private String payment_no;
	private String payment_time;

	public String getReturn_code() {
		return return_code;
	}

	public TransfersResponse setReturn_code(String return_code) {
		this.return_code = return_code;
		return this;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public TransfersResponse setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
		return this;
	}

	public String getMch_appid() {
		return mch_appid;
	}

	public TransfersResponse setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
		return this;
	}

	public String getMchid() {
		return mchid;
	}

	public TransfersResponse setMchid(String mchid) {
		this.mchid = mchid;
		return this;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public TransfersResponse setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
		return this;
	}

	public String getResult_code() {
		return result_code;
	}

	public TransfersResponse setResult_code(String result_code) {
		this.result_code = result_code;
		return this;
	}

	public String getErr_code() {
		return err_code;
	}

	public TransfersResponse setErr_code(String err_code) {
		this.err_code = err_code;
		return this;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public TransfersResponse setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
		return this;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public TransfersResponse setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
		return this;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public TransfersResponse setPayment_no(String payment_no) {
		this.payment_no = payment_no;
		return this;
	}

	public String getPayment_time() {
		return payment_time;
	}

	public TransfersResponse setPayment_time(String payment_time) {
		this.payment_time = payment_time;
		return this;
	}
}
