package org.cluo.framework.sdk.all.tencent.api.im;


public class ImMessageResponse {
    private String ActionStatus;

    private String ErrorInfo;

    private Integer ErrorCode;

    private Long MsgTime;

    public String getActionStatus() {
        return ActionStatus;
    }

    public void setActionStatus(String actionStatus) {
        ActionStatus = actionStatus;
    }

    public String getErrorInfo() {
        return ErrorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        ErrorInfo = errorInfo;
    }

    public Integer getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(Integer errorCode) {
        ErrorCode = errorCode;
    }

    public Long getMsgTime() {
        return MsgTime;
    }

    public void setMsgTime(Long msgTime) {
        MsgTime = msgTime;
    }
}
