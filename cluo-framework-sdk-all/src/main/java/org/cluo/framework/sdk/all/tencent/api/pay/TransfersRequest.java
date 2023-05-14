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
public class TransfersRequest  extends Param<TransfersRequest> implements Serializable {
	public TransfersRequest(HttpRequest<TransfersRequest> request) {
		super(request);
	}
	private String mch_appid;
	private String mchid;
	private String nonce_str;
	private String sign;
	private String partner_trade_no;
	private String openid;
	private String check_name;
	private String re_user_name;
	private Integer amount;
	private String desc;
	private String spbill_create_ip;
	private String device_info;

	public String getMch_appid() {
		return mch_appid;
	}

	public TransfersRequest setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
		return this;
	}

	public String getMchid() {
		return mchid;
	}

	public TransfersRequest setMchid(String mchid) {
		this.mchid = mchid;
		return this;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public TransfersRequest setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
		return this;
	}

	public String getSign() {
		return sign;
	}

	public TransfersRequest setSign(String sign) {
		this.sign = sign;
		return this;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public TransfersRequest setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
		return this;
	}

	public String getOpenid() {
		return openid;
	}

	public TransfersRequest setOpenid(String openid) {
		this.openid = openid;
		return this;
	}

	public String getCheck_name() {
		return check_name;
	}

	public TransfersRequest setCheck_name(String check_name) {
		this.check_name = check_name;
		return this;
	}

	public String getRe_user_name() {
		return re_user_name;
	}

	public TransfersRequest setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
		return this;
	}

	public Integer getAmount() {
		return amount;
	}

	public TransfersRequest setAmount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public TransfersRequest setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public TransfersRequest setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
		return this;
	}

	public String getDevice_info() {
		return device_info;
	}

	public TransfersRequest setDevice_info(String device_info) {
		this.device_info = device_info;
		return this;
	}
}
