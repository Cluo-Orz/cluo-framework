package org.cluo.framework.sdk.all.tencent.api.echo.api.PullComplete;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;

import java.io.Serializable;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.PullComplete
 * Create in 13:39 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Request extends EchoBaseRequest<Request.Data> {
    public static class Data implements Serializable {
        private Integer status;
        private String message;
        private String fileId;
        private String fileUrl;
        private String transcodeTaskId;
        private String porncheckTaskId;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public String getTranscodeTaskId() {
            return transcodeTaskId;
        }

        public void setTranscodeTaskId(String transcodeTaskId) {
            this.transcodeTaskId = transcodeTaskId;
        }

        public String getPorncheckTaskId() {
            return porncheckTaskId;
        }

        public void setPorncheckTaskId(String porncheckTaskId) {
            this.porncheckTaskId = porncheckTaskId;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("status=").append(status);
            sb.append(", message='").append(message).append('\'');
            sb.append(", fileId='").append(fileId).append('\'');
            sb.append(", fileUrl='").append(fileUrl).append('\'');
            sb.append(", transcodeTaskId='").append(transcodeTaskId).append('\'');
            sb.append(", porncheckTaskId='").append(porncheckTaskId).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
