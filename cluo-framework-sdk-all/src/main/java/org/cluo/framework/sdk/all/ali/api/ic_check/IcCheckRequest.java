package org.cluo.framework.sdk.all.ali.api.ic_check;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.ic_check
 * Create in 22:04 2018/8/23
 *
 * author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IcCheckRequest extends Param<IcCheckRequest>{
	public IcCheckRequest(HttpRequest<IcCheckRequest> request) {
		super(request);
	}
	private String enterpriseName;

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public IcCheckRequest setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
		return this;
	}
}
