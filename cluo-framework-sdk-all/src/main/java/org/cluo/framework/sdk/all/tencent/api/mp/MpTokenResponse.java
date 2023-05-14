package org.cluo.framework.sdk.all.tencent.api.mp;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.mp
 * Create in 23:49 2018/9/11
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class MpTokenResponse implements Serializable{
	private String access_token;
	private Long expires_in;
	private Long errcode;
	private String errmsg;

	public String getAccess_token() {
		return access_token;
	}

	public MpTokenResponse setAccess_token(String access_token) {
		this.access_token = access_token;
		return this;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public MpTokenResponse setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
		return this;
	}

	public Long getErrcode() {
		return errcode;
	}

	public MpTokenResponse setErrcode(Long errcode) {
		this.errcode = errcode;
		return this;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public MpTokenResponse setErrmsg(String errmsg) {
		this.errmsg = errmsg;
		return this;
	}
}
