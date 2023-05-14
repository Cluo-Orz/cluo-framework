package org.cluo.framework.sdk.all.tencent.api.echo.api.CreateSnapshotByTimeOffsetComplete;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.CreateSnapshotByTimeOffsetComplete
 * Create in 13:46 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Request extends EchoBaseRequest<Request.Data> {
    public static class Data implements Serializable {
        private String vodTaskId;
        private String fileId;
        private Integer definition;
        private List<PicInfo> picInfo;

        public static class PicInfo implements Serializable {
            private Integer timeOffset;
            private String url;
            private Integer status;

            public Integer getTimeOffset() {
                return timeOffset;
            }

            public void setTimeOffset(Integer timeOffset) {
                this.timeOffset = timeOffset;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }
        }

        public String getVodTaskId() {
            return vodTaskId;
        }

        public void setVodTaskId(String vodTaskId) {
            this.vodTaskId = vodTaskId;
        }

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public Integer getDefinition() {
            return definition;
        }

        public void setDefinition(Integer definition) {
            this.definition = definition;
        }

        public List<PicInfo> getPicInfo() {
            return picInfo;
        }

        public void setPicInfo(List<PicInfo> picInfo) {
            this.picInfo = picInfo;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("vodTaskId='").append(vodTaskId).append('\'');
            sb.append(", fileId='").append(fileId).append('\'');
            sb.append(", definition=").append(definition);
            sb.append(", picInfo=").append(picInfo);
            sb.append('}');
            return sb.toString();
        }
    }
}
