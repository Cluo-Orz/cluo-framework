package org.cluo.framework.sdk.all.tencent.api.media.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.media.BaseResponse;

import java.io.Serializable;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:12 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class EditMediaResponse extends BaseResponse implements Serializable {
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
        return "SearchMediaResponse{" +
                "response=" + response +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
