package org.cluo.framework.sdk.all.ali.api.bank_check;

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
public class BankCheckRequest extends Param<BankCheckRequest> implements Serializable{
	private String accountNo;
	private String idCard;
	private String name;

	public BankCheckRequest(HttpRequest<BankCheckRequest> request) {
		super(request);
	}

	public String getIdCard() {
		return idCard;
	}

	public BankCheckRequest setIdCard(String idCard) {
		this.idCard = idCard;
		return this;
	}

	public String getName() {
		return name;
	}

	public BankCheckRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public BankCheckRequest setAccountNo(String accountNo) {
		this.accountNo = accountNo;
		return this;
	}
}
