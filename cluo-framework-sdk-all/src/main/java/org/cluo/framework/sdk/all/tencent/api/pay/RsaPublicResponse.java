package org.cluo.framework.sdk.all.tencent.api.pay;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.pay
 * Create in 16:29 2018/9/10
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class RsaPublicResponse implements Serializable {

	private String return_code;
	private String return_msg;
	private String mchid;
	private String result_code;
	private String err_code;
	private String err_code_des;
	private String pub_key;

	public String getPub_key() {
		return pub_key;
	}

	public void setPub_key(String pub_key) {
		this.pub_key = pub_key;
	}

	public String getReturn_code() {
		return return_code;
	}

	public RsaPublicResponse setReturn_code(String return_code) {
		this.return_code = return_code;
		return this;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public RsaPublicResponse setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
		return this;
	}

	public String getMchid() {
		return mchid;
	}

	public RsaPublicResponse setMchid(String mchid) {
		this.mchid = mchid;
		return this;
	}

	public String getResult_code() {
		return result_code;
	}

	public RsaPublicResponse setResult_code(String result_code) {
		this.result_code = result_code;
		return this;
	}

	public String getErr_code() {
		return err_code;
	}

	public RsaPublicResponse setErr_code(String err_code) {
		this.err_code = err_code;
		return this;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public RsaPublicResponse setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
		return this;
	}

}
