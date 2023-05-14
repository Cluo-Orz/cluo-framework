package org.cluo.framework.sdk.all.tencent.api.echo.api.ClipComplete;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;

import java.io.Serializable;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.ClipComplete
 * Create in 13:56 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Request extends EchoBaseRequest<Request.Data> {
    public static class Data implements Serializable {
        private String vodTaskId;
        private String srcFileId;
        private FileInfo fileInfo;

        public static class FileInfo implements Serializable {
            private String fileType;
            private Integer status;
            private String message;
            private String fileId;
            private String fileUrl;

            public String getFileType() {
                return fileType;
            }

            public void setFileType(String fileType) {
                this.fileType = fileType;
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
                final StringBuffer sb = new StringBuffer("FileInfo{");
                sb.append("fileType='").append(fileType).append('\'');
                sb.append(", status=").append(status);
                sb.append(", message='").append(message).append('\'');
                sb.append(", fileId='").append(fileId).append('\'');
                sb.append(", fileUrl='").append(fileUrl).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        public String getVodTaskId() {
            return vodTaskId;
        }

        public void setVodTaskId(String vodTaskId) {
            this.vodTaskId = vodTaskId;
        }

        public String getSrcFileId() {
            return srcFileId;
        }

        public void setSrcFileId(String srcFileId) {
            this.srcFileId = srcFileId;
        }

        public FileInfo getFileInfo() {
            return fileInfo;
        }

        public void setFileInfo(FileInfo fileInfo) {
            this.fileInfo = fileInfo;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("vodTaskId='").append(vodTaskId).append('\'');
            sb.append(", srcFileId='").append(srcFileId).append('\'');
            sb.append(", fileInfo=").append(fileInfo);
            sb.append('}');
            return sb.toString();
        }
    }
}
