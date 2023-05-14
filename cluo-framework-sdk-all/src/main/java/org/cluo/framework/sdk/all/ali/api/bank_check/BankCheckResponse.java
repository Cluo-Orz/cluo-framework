package org.cluo.framework.sdk.all.ali.api.bank_check;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.id_check
 * Create in 23:12 2018/8/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class BankCheckResponse implements Serializable{
	private String status;
	private String msg;
	private String idCard;
	private String accountNo;
	private String bank;
	private String cardName;
	private String cardType;
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

	public BankCheckResponse setIdCard(String idCard) {
		this.idCard = idCard;
		return this;
	}

	public String getName() {
		return name;
	}

	public BankCheckResponse setName(String name) {
		this.name = name;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public BankCheckResponse setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public String getArea() {
		return area;
	}

	public BankCheckResponse setArea(String area) {
		this.area = area;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public BankCheckResponse setProvince(String province) {
		this.province = province;
		return this;
	}

	public String getCity() {
		return city;
	}

	public BankCheckResponse setCity(String city) {
		this.city = city;
		return this;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public BankCheckResponse setPrefecture(String prefecture) {
		this.prefecture = prefecture;
		return this;
	}

	public String getBirthday() {
		return birthday;
	}

	public BankCheckResponse setBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}

	public String getAddrCode() {
		return addrCode;
	}

	public BankCheckResponse setAddrCode(String addrCode) {
		this.addrCode = addrCode;
		return this;
	}

	public String getLastCode() {
		return lastCode;
	}

	public BankCheckResponse setLastCode(String lastCode) {
		this.lastCode = lastCode;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public BankCheckResponse setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public BankCheckResponse setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public BankCheckResponse setAccountNo(String accountNo) {
		this.accountNo = accountNo;
		return this;
	}

	public String getBank() {
		return bank;
	}

	public BankCheckResponse setBank(String bank) {
		this.bank = bank;
		return this;
	}

	public String getCardName() {
		return cardName;
	}

	public BankCheckResponse setCardName(String cardName) {
		this.cardName = cardName;
		return this;
	}

	public String getCardType() {
		return cardType;
	}

	public BankCheckResponse setCardType(String cardType) {
		this.cardType = cardType;
		return this;
	}

	public boolean pass(){
		return "01".equals(status);
	}

}
