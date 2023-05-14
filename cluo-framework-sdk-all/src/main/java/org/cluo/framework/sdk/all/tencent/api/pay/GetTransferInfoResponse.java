package org.cluo.framework.sdk.all.tencent.api.pay;


/**
 * In services-org.cluo.framework.sdk.all.tencent.api.pay
 * Create in 13:59 2018/9/11
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class GetTransferInfoResponse{
	private String return_code;
	private String return_msg;
	private String result_code;
	private String err_code;
	private String err_code_des;
	private String partner_trade_no;
	private String mch_id;
	private String detail_id;
	private String status;
	private String reason;
	private String openid;
	private String transfer_name;
	private Integer payment_amount;
	private String transfer_time;
	private String desc;

	public String getReturn_code() {
		return return_code;
	}

	public GetTransferInfoResponse setReturn_code(String return_code) {
		this.return_code = return_code;
		return this;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public GetTransferInfoResponse setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
		return this;
	}

	public String getResult_code() {
		return result_code;
	}

	public GetTransferInfoResponse setResult_code(String result_code) {
		this.result_code = result_code;
		return this;
	}

	public String getErr_code() {
		return err_code;
	}

	public GetTransferInfoResponse setErr_code(String err_code) {
		this.err_code = err_code;
		return this;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public GetTransferInfoResponse setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
		return this;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public GetTransferInfoResponse setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
		return this;
	}

	public String getMch_id() {
		return mch_id;
	}

	public GetTransferInfoResponse setMch_id(String mch_id) {
		this.mch_id = mch_id;
		return this;
	}

	public String getDetail_id() {
		return detail_id;
	}

	public GetTransferInfoResponse setDetail_id(String detail_id) {
		this.detail_id = detail_id;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public GetTransferInfoResponse setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getReason() {
		return reason;
	}

	public GetTransferInfoResponse setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public String getOpenid() {
		return openid;
	}

	public GetTransferInfoResponse setOpenid(String openid) {
		this.openid = openid;
		return this;
	}

	public String getTransfer_name() {
		return transfer_name;
	}

	public GetTransferInfoResponse setTransfer_name(String transfer_name) {
		this.transfer_name = transfer_name;
		return this;
	}

	public Integer getPayment_amount() {
		return payment_amount;
	}

	public GetTransferInfoResponse setPayment_amount(Integer payment_amount) {
		this.payment_amount = payment_amount;
		return this;
	}

	public String getTransfer_time() {
		return transfer_time;
	}

	public GetTransferInfoResponse setTransfer_time(String transfer_time) {
		this.transfer_time = transfer_time;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public GetTransferInfoResponse setDesc(String desc) {
		this.desc = desc;
		return this;
	}
}
