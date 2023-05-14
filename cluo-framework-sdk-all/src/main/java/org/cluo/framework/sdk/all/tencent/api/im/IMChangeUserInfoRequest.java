package org.cluo.framework.sdk.all.tencent.api.im;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;
import java.util.List;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.im
 * Create in 21:21 2018/11/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IMChangeUserInfoRequest extends Param<IMChangeUserInfoRequest> implements Serializable {
	/**
	 * From_Account : id
	 * ProfileItem : [{"Tag":"Tag_Profile_IM_Nick","Value":"MyNickName"}]
	 */

	private String From_Account;
	private List<ProfileItemResponse> ProfileItem;

	public IMChangeUserInfoRequest(HttpRequest<IMChangeUserInfoRequest> request) {
		super(request);
	}

	public String getFrom_Account() {
		return From_Account;
	}

	public IMChangeUserInfoRequest setFrom_Account(String From_Account) {
		this.From_Account = From_Account;
		return this;
	}

	public List<ProfileItemResponse> getProfileItem() {
		return ProfileItem;
	}

	public IMChangeUserInfoRequest setProfileItem(List<ProfileItemResponse> ProfileItem) {
		this.ProfileItem = ProfileItem;
		return this;
	}

	public static class ProfileItemResponse {
		/**
		 * Tag : Tag_Profile_IM_Nick
		 * Value : MyNickName
		 */

		private String Tag;
		private String Value;

		public String getTag() {
			return Tag;
		}

		public void setTag(String Tag) {
			this.Tag = Tag;
		}

		public String getValue() {
			return Value;
		}

		public void setValue(String Value) {
			this.Value = Value;
		}
	}
}
