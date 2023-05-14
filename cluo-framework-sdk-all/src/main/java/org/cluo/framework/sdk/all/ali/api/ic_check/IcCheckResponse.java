package org.cluo.framework.sdk.all.ali.api.ic_check;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.ic_check
 * Create in 22:06 2018/8/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IcCheckResponse implements Serializable{
	private ShowApiResBody showapi_res_body;

	public static class ShowApiResBody implements Serializable{
		private String enterpriseName;
		private String credit;
		private String reglegalPerson;

		public String getCredit() {
			return credit;
		}

		public ShowApiResBody setCredit(String credit) {
			this.credit = credit;
			return this;
		}

		public String getReglegalPerson() {
			return reglegalPerson;
		}

		public ShowApiResBody setReglegalPerson(String reglegalPerson) {
			this.reglegalPerson = reglegalPerson;
			return this;
		}

		public String getEnterpriseName() {
			return enterpriseName;
		}

		public ShowApiResBody setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
			return this;
		}
	}
}
