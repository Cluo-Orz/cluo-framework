package org.cluo.framework.sdk.all.tencent.api.pay;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

/**
 * In services-org.cluo.framework.sdk.all.tencent.api.pay
 * Create in 13:57 2018/9/11
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class GetTransferInfoRequest extends Param<GetTransferInfoRequest>{
	public GetTransferInfoRequest(HttpRequest<GetTransferInfoRequest> request) {
		super(request);
	}
	private String nonce_str;
	private String partner_trade_no;
	private String mch_id;
	private String appid;
	private String sign;

	public String getNonce_str() {
		return nonce_str;
	}

	public GetTransferInfoRequest setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
		return this;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public GetTransferInfoRequest setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
		return this;
	}

	public String getMch_id() {
		return mch_id;
	}

	public GetTransferInfoRequest setMch_id(String mch_id) {
		this.mch_id = mch_id;
		return this;
	}

	public String getAppid() {
		return appid;
	}

	public GetTransferInfoRequest setAppid(String appid) {
		this.appid = appid;
		return this;
	}

	public String getSign() {
		return sign;
	}

	public GetTransferInfoRequest setSign(String sign) {
		this.sign = sign;
		return this;
	}
}
