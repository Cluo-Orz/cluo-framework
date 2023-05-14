package org.cluo.framework.sdk.all.ali.api.ic_orc;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.ic_orc
 * Create in 23:00 2018/8/23
 *
 * author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IcOrcRequest extends Param<IcOrcRequest> implements Serializable{
	private String image;

	public IcOrcRequest(HttpRequest<IcOrcRequest> request) {
		super(request);
	}

	public String getImage() {
		return image;
	}

	public IcOrcRequest setImage(String image) {
		this.image = image;
		return this;
	}
}
