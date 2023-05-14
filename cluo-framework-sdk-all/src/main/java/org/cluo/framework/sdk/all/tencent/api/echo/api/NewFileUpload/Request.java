package org.cluo.framework.sdk.all.tencent.api.echo.api.NewFileUpload;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;

import java.io.Serializable;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.NewFileUpload
 * Create in 13:32 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Request extends EchoBaseRequest<Request.Data> implements Serializable {

    public static class Data implements Serializable {
        private String fileId;
        private String fileName;
        private String coverUrl;
        private String author;
        private String sourceType;
        private String sourceContext;
        private String streamId;
        private String procedureTaskId;
        private String transcodeTaskId;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public String getSourceContext() {
            return sourceContext;
        }

        public void setSourceContext(String sourceContext) {
            this.sourceContext = sourceContext;
        }

        public String getStreamId() {
            return streamId;
        }

        public void setStreamId(String streamId) {
            this.streamId = streamId;
        }

        public String getProcedureTaskId() {
            return procedureTaskId;
        }

        public void setProcedureTaskId(String procedureTaskId) {
            this.procedureTaskId = procedureTaskId;
        }

        public String getTranscodeTaskId() {
            return transcodeTaskId;
        }

        public void setTranscodeTaskId(String transcodeTaskId) {
            this.transcodeTaskId = transcodeTaskId;
        }


        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("fileId='").append(fileId).append('\'');
            sb.append(", fileName='").append(fileName).append('\'');
            sb.append(", coverUrl='").append(coverUrl).append('\'');
            sb.append(", author='").append(author).append('\'');
            sb.append(", sourceType='").append(sourceType).append('\'');
            sb.append(", sourceContext='").append(sourceContext).append('\'');
            sb.append(", streamId='").append(streamId).append('\'');
            sb.append(", procedureTaskId='").append(procedureTaskId).append('\'');
            sb.append(", transcodeTaskId='").append(transcodeTaskId).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
