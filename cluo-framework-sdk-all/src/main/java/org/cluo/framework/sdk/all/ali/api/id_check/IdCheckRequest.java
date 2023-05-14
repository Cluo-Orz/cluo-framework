package org.cluo.framework.sdk.all.ali.api.id_check;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.id_check
 * Create in 23:09 2018/8/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IdCheckRequest extends Param<IdCheckRequest> implements Serializable{
	private String idCard;
	private String name;

	public IdCheckRequest(HttpRequest<IdCheckRequest> request) {
		super(request);
	}

	public String getIdCard() {
		return idCard;
	}

	public IdCheckRequest setIdCard(String idCard) {
		this.idCard = idCard;
		return this;
	}

	public String getName() {
		return name;
	}

	public IdCheckRequest setName(String name) {
		this.name = name;
		return this;
	}
}
