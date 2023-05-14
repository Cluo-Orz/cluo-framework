package org.cluo.framework.sdk.all.tencent.api.echo.api.CreateImageSpriteComplete;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.CreateImageSpriteComplete
 * Create in 13:50 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Request extends EchoBaseRequest<Request.Data> {

    public static class Data implements Serializable {
        private Integer status;
        private String message;
        private String vodTaskId;
        private String fileId;
        private Integer definition;
        private Integer totalCount;
        private List<String> imageSpriteUrl;
        private String webVttUrl;

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

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public List<String> getImageSpriteUrl() {
            return imageSpriteUrl;
        }

        public void setImageSpriteUrl(List<String> imageSpriteUrl) {
            this.imageSpriteUrl = imageSpriteUrl;
        }

        public String getWebVttUrl() {
            return webVttUrl;
        }

        public void setWebVttUrl(String webVttUrl) {
            this.webVttUrl = webVttUrl;
        }
    }
}
