package org.cluo.framework.sdk.all.tencent.api.media.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.media.BaseResponse;
import org.cluo.framework.sdk.all.tencent.api.media.api.response.*;

import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:12 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class TaskResponse extends BaseResponse implements Serializable {
    @JsonProperty("Response")
    private Response response;

    public static class Response implements Serializable {
        @JsonProperty("TaskType")
        private String taskType;
        @JsonProperty("Status")
        private String status;
        @JsonProperty("CreateTime")
        private String createTime;
        @JsonProperty("BeginProcessTime")
        private String beginProcessTime;
        @JsonProperty("finishTime")
        private String FinishTime;
        @JsonProperty("EditMediaTask")
        private EditMediaTask editMediaTask;

        public static class EditMediaTask implements Serializable {
            @JsonProperty("TaskId")
            private String taskId;
            @JsonProperty("Status")
            private String status;
            @JsonProperty("ErrCode")
            private String errCode;
            @JsonProperty("Message")
            private String message;
            @JsonProperty("ProcedureTaskId")
            private String procedureTaskId;
            @JsonProperty("Output")
            private EditMediaTaskOutput output;

            public static class EditMediaTaskOutput implements Serializable{
                @JsonProperty("FileType")
                private String fileType;
                @JsonProperty("FileId")
                private String fileId;
                @JsonProperty("FileUrl")
                private String fileUrl;

                public String getFileType() {
                    return fileType;
                }

                public void setFileType(String fileType) {
                    this.fileType = fileType;
                }

                public String getFileId() {
                    return fileId;
                }

                public void setFileId(String fileId) {
                    this.fileId = fileId;
                }

                public String getFileUrl() {
                    return fileUrl;
                }

                public void setFileUrl(String fileUrl) {
                    this.fileUrl = fileUrl;
                }

                @Override
                public String toString() {
                    return "EditMediaTaskOutput{" +
                            "fileType='" + fileType + '\'' +
                            ", fileId='" + fileId + '\'' +
                            ", fileUrl='" + fileUrl + '\'' +
                            '}';
                }
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getErrCode() {
                return errCode;
            }

            public void setErrCode(String errCode) {
                this.errCode = errCode;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getProcedureTaskId() {
                return procedureTaskId;
            }

            public void setProcedureTaskId(String procedureTaskId) {
                this.procedureTaskId = procedureTaskId;
            }

            public EditMediaTaskOutput getOutput() {
                return output;
            }

            public void setOutput(EditMediaTaskOutput output) {
                this.output = output;
            }

            @Override
            public String toString() {
                return "EditMediaTask{" +
                        "taskId='" + taskId + '\'' +
                        ", status='" + status + '\'' +
                        ", errCode='" + errCode + '\'' +
                        ", message='" + message + '\'' +
                        ", procedureTaskId='" + procedureTaskId + '\'' +
                        ", output=" + output +
                        '}';
            }
        }

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getBeginProcessTime() {
            return beginProcessTime;
        }

        public void setBeginProcessTime(String beginProcessTime) {
            this.beginProcessTime = beginProcessTime;
        }

        public String getFinishTime() {
            return FinishTime;
        }

        public void setFinishTime(String finishTime) {
            FinishTime = finishTime;
        }

        public EditMediaTask getEditMediaTask() {
            return editMediaTask;
        }

        public void setEditMediaTask(EditMediaTask editMediaTask) {
            this.editMediaTask = editMediaTask;
        }

        @Override
        public String toString() {
            return "TaskResponse{" +
                    "taskType='" + taskType + '\'' +
                    ", status='" + status + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", beginProcessTime='" + beginProcessTime + '\'' +
                    ", FinishTime='" + FinishTime + '\'' +
                    ", editMediaTask=" + editMediaTask +
                    '}';
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "TaskResponse{" +
                "response=" + response +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
