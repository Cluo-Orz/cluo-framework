package org.cluo.framework.sdk.all.tencent.api.echo.api.TranscodeComplete;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.TranscodeComplete
 * Create in 13:42 2018/7/13
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
        private Integer duration;
        private String vodTaskId;
        private List<Play> playSet;

        public static class Play implements Serializable {
            private Integer vbitrate;
            private Integer definition;
            private Integer vheight;
            private Integer vwidth;
            private String url = "";

            public Integer getVbitrate() {
                return vbitrate;
            }

            public Play setVbitrate(Integer vbitrate) {
                this.vbitrate = vbitrate;
                return this;
            }

            public Integer getDefinition() {
                return definition;
            }

            public Play setDefinition(Integer definition) {
                this.definition = definition;
                return this;
            }

            public Integer getVheight() {
                return vheight;
            }

            public Play setVheight(Integer vheight) {
                this.vheight = vheight;
                return this;
            }

            public Integer getVwidth() {
                return vwidth;
            }

            public Play setVwidth(Integer vwidth) {
                this.vwidth = vwidth;
                return this;
            }

            public String getUrl() {
                return url;
            }

            public Play setUrl(String url) {
                this.url = url;
                return this;
            }
        }

        public Integer getDuration() {
            return duration;
        }

        public Data setDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public List<Play> getPlaySet() {
            return playSet;
        }

        public Data setPlaySet(List<Play> playSet) {
            this.playSet = playSet;
            return this;
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

        public String getVodTaskId() {
            return vodTaskId;
        }

        public void setVodTaskId(String vodTaskId) {
            this.vodTaskId = vodTaskId;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("status=").append(status);
            sb.append(", message='").append(message).append('\'');
            sb.append(", fileId='").append(fileId).append('\'');
            sb.append(", vodTaskId='").append(vodTaskId).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
