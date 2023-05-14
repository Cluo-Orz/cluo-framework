package org.cluo.framework.sdk.all.tencent.api.pay;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.pay
 * Create in 16:22 2018/9/10
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class TransBankRequest extends Param<TransBankRequest> implements Serializable {
	public TransBankRequest(HttpRequest<TransBankRequest> request) {
		super(request);
	}
	private String mch_id;
	private String nonce_str;
	private String sign;
	private String partner_trade_no;
	private String enc_bank_no;
	private String enc_true_name;
	private String bank_code;
	private Integer amount;
	private String desc;

	public String getMch_id() {
		return mch_id;
	}

	public TransBankRequest setMch_id(String mch_id) {
		this.mch_id = mch_id;
		return this;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public TransBankRequest setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
		return this;
	}

	public String getSign() {
		return sign;
	}

	public TransBankRequest setSign(String sign) {
		this.sign = sign;
		return this;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public TransBankRequest setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
		return this;
	}

	public Integer getAmount() {
		return amount;
	}

	public TransBankRequest setAmount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public TransBankRequest setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getEnc_bank_no() {
		return enc_bank_no;
	}

	public TransBankRequest setEnc_bank_no(String enc_bank_no) {
		this.enc_bank_no = enc_bank_no;
		return this;
	}

	public String getEnc_true_name() {
		return enc_true_name;
	}

	public TransBankRequest setEnc_true_name(String enc_true_name) {
		this.enc_true_name = enc_true_name;
		return this;
	}

	public String getBank_code() {
		return bank_code;
	}

	public TransBankRequest setBank_code(String bank_code) {
		this.bank_code = bank_code;
		return this;
	}

	@Override
	public String toString() {
		return "TransBankRequest{" +
				"mch_id='" + mch_id + '\'' +
				", nonce_str='" + nonce_str + '\'' +
				", sign='" + sign + '\'' +
				", partner_trade_no='" + partner_trade_no + '\'' +
				", enc_bank_no='" + enc_bank_no + '\'' +
				", enc_true_name='" + enc_true_name + '\'' +
				", bank_code='" + bank_code + '\'' +
				", amount=" + amount +
				", desc='" + desc + '\'' +
				'}';
	}
}
