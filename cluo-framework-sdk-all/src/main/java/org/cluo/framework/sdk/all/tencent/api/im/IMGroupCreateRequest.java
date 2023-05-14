package org.cluo.framework.sdk.all.tencent.api.im;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.im
 * Create in 00:37 2018/8/21
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IMGroupCreateRequest extends Param<IMGroupCreateRequest> implements Serializable{
	@JsonProperty("Type")
	private String Type;
	@JsonProperty("GroupId")
	private String GroupId;
	@JsonProperty("Name")
	private String Name;

	public IMGroupCreateRequest(HttpRequest<IMGroupCreateRequest> request) {
		super(request);
	}

	public String getType() {
		return Type;
	}

	public IMGroupCreateRequest setType(String type) {
		Type = type;
		return this;
	}

	public String getGroupId() {
		return GroupId;
	}

	public IMGroupCreateRequest setGroupId(String groupId) {
		GroupId = groupId;
		return this;
	}

	public String getName() {
		return Name;
	}

	public IMGroupCreateRequest setName(String name) {
		Name = name;
		return this;
	}
}
