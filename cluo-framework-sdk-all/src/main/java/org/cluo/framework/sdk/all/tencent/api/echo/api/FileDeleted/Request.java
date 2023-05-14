package org.cluo.framework.sdk.all.tencent.api.echo.api.FileDeleted;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.FileDeleted
 * Create in 14:31 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Request extends EchoBaseRequest<Request.Data> {
    public static class Data implements Serializable {
        private Integer status;
        private String message;
        private List<FileInfo> fileInfo;

        public static class FileInfo implements Serializable {
            private String fileId;

            public String getFileId() {
                return fileId;
            }

            public void setFileId(String fileId) {
                this.fileId = fileId;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("FileInfo{");
                sb.append("fileId='").append(fileId).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

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

        public List<FileInfo> getFileInfo() {
            return fileInfo;
        }

        public void setFileInfo(List<FileInfo> fileInfo) {
            this.fileInfo = fileInfo;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("status=").append(status);
            sb.append(", message='").append(message).append('\'');
            sb.append(", fileInfo=").append(fileInfo);
            sb.append('}');
            return sb.toString();
        }
    }
}
