package org.cluo.framework.sdk.all.tencent.api.pay;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.pay
 * Create in 16:22 2018/9/10
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class RsaPublicRequest extends Param<RsaPublicRequest> implements Serializable {
	public RsaPublicRequest(HttpRequest<RsaPublicRequest> request) {
		super(request);
	}
	private String mch_id;
	private String nonce_str;
	private String sign;
	private String sign_type;

	public String getSign_type() {
		return sign_type;
	}

	public RsaPublicRequest setSign_type(String sign_type) {
		this.sign_type = sign_type;
		return this;
	}

	public String getMch_id() {
		return mch_id;
	}

	public RsaPublicRequest setMch_id(String mch_id) {
		this.mch_id = mch_id;
		return this;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public RsaPublicRequest setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
		return this;
	}

	public String getSign() {
		return sign;
	}

	public RsaPublicRequest setSign(String sign) {
		this.sign = sign;
		return this;
	}

	@Override
	public String toString() {
		return "RsaPublicRequest{" +
				"mch_id='" + mch_id + '\'' +
				", nonce_str='" + nonce_str + '\'' +
				", sign='" + sign + '\'' +
				", sign_type='" + sign_type + '\'' +
				'}';
	}
}
