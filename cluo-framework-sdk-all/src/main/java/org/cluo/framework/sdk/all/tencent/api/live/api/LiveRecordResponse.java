package org.cluo.framework.sdk.all.tencent.api.live.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * author: thone
 * time: 2019/5/31 下午2:40
 * desc: //TODO
 **/
public class LiveRecordResponse implements Serializable {
    @JsonProperty("Response")
    private Response response;

    public static class Response implements Serializable {
        @JsonProperty("RequestId")
        private String requestId;

        @JsonProperty("TaskId")
        private String taskId;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "requestId='" + requestId + '\'' +
                    ", taskId='" + taskId + '\'' +
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
        return "LiveRecordResponse{" +
                "response=" + response +
                '}';
    }
}
