package org.cluo.framework.sdk.all.tencent.api.im;


/**
 * @author: thone
 * time: 2019/4/7 下午4:42
 * desc: //TODO
 **/
public class ImGroupResponse {
    private String ActionStatus;

    private String ErrorInfo;

    private Integer ErrorCode;

    private String GroupId;

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

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }
}
