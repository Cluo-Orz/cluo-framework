package org.cluo.framework.sdk.all.ali.api.id_check;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.id_check
 * Create in 23:12 2018/8/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IdCheckResponse implements Serializable{
	private String status;

		private String idCard;
		private String name;
		private String sex;
		private String area;
		private String province;
		private String city;
		private String prefecture;
		private String birthday;
		private String addrCode;
		private String lastCode;

		public String getIdCard() {
			return idCard;
		}

		public IdCheckResponse setIdCard(String idCard) {
			this.idCard = idCard;
			return this;
		}

		public String getName() {
			return name;
		}

		public IdCheckResponse setName(String name) {
			this.name = name;
			return this;
		}

		public String getSex() {
			return sex;
		}

		public IdCheckResponse setSex(String sex) {
			this.sex = sex;
			return this;
		}

		public String getArea() {
			return area;
		}

		public IdCheckResponse setArea(String area) {
			this.area = area;
			return this;
		}

		public String getProvince() {
			return province;
		}

		public IdCheckResponse setProvince(String province) {
			this.province = province;
			return this;
		}

		public String getCity() {
			return city;
		}

		public IdCheckResponse setCity(String city) {
			this.city = city;
			return this;
		}

		public String getPrefecture() {
			return prefecture;
		}

		public IdCheckResponse setPrefecture(String prefecture) {
			this.prefecture = prefecture;
			return this;
		}

		public String getBirthday() {
			return birthday;
		}

		public IdCheckResponse setBirthday(String birthday) {
			this.birthday = birthday;
			return this;
		}

		public String getAddrCode() {
			return addrCode;
		}

		public IdCheckResponse setAddrCode(String addrCode) {
			this.addrCode = addrCode;
			return this;
		}

		public String getLastCode() {
			return lastCode;
		}

		public IdCheckResponse setLastCode(String lastCode) {
			this.lastCode = lastCode;
			return this;
		}

	public String getStatus() {
		return status;
	}

	public IdCheckResponse setStatus(String status) {
		this.status = status;
		return this;
	}

	public boolean pass(){
		return "01".equals(status);
	}

}
