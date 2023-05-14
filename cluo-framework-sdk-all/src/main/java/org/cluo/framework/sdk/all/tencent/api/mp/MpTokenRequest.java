package org.cluo.framework.sdk.all.tencent.api.mp;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.mp
 * Create in 22:20 2018/9/11
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class MpTokenRequest extends Param<MpTokenRequest> implements Serializable{
	public MpTokenRequest(HttpRequest<MpTokenRequest> request) {
		super(request);
	}
	private String grant_type = "client_credential";
	private String appid;
	private String secret;

	public String getGrant_type() {
		return grant_type;
	}

	public MpTokenRequest setGrant_type(String grant_type) {
		this.grant_type = grant_type;
		return this;
	}

	public String getAppid() {
		return appid;
	}

	public MpTokenRequest setAppid(String appid) {
		this.appid = appid;
		return this;
	}

	public String getSecret() {
		return secret;
	}

	public MpTokenRequest setSecret(String secret) {
		this.secret = secret;
		return this;
	}
}
