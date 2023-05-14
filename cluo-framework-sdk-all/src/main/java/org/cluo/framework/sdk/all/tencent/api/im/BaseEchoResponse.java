package org.cluo.framework.sdk.all.tencent.api.im;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.im
 * Create in 12:50 2018/8/20
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class BaseEchoResponse implements Serializable{
	protected String ActionStatus = "OK";
	protected String ErrorInfo = "";
	protected Integer ErrorCode = 0;

	public String getActionStatus() {
		return ActionStatus;
	}

	public BaseEchoResponse setActionStatus(String actionStatus) {
		ActionStatus = actionStatus;
		return this;
	}

	public String getErrorInfo() {
		return ErrorInfo;
	}

	public BaseEchoResponse setErrorInfo(String errorInfo) {
		ErrorInfo = errorInfo;
		return this;
	}

	public Integer getErrorCode() {
		return ErrorCode;
	}

	public BaseEchoResponse setErrorCode(Integer errorCode) {
		ErrorCode = errorCode;
		return this;
	}
}
