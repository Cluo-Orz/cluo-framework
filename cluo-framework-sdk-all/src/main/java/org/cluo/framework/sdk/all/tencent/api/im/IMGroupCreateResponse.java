package org.cluo.framework.sdk.all.tencent.api.im;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.im
 * Create in 00:39 2018/8/21
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IMGroupCreateResponse extends BaseEchoResponse{
	private String GroupId;

	public String getGroupId() {
		return GroupId;
	}

	public IMGroupCreateResponse setGroupId(String groupId) {
		GroupId = groupId;
		return this;
	}
}
