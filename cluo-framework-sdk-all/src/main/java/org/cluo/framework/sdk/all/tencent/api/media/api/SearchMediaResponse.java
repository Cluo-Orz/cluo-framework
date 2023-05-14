package org.cluo.framework.sdk.all.tencent.api.media.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.media.BaseResponse;
import org.cluo.framework.sdk.all.tencent.api.media.api.response.*;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:12 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class SearchMediaResponse extends BaseResponse implements Serializable {
    @JsonProperty("Response")
    private Response response;

    public static class Response implements Serializable {
        @JsonProperty("TotalCount")
        private String totalCount;
        @JsonProperty("RequestId")
        private String requestId;

        @JsonProperty("MediaInfoSet")
        private List<MediaInfoSetResponse> mediaInfoSet;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public List<MediaInfoSetResponse> getMediaInfoSet() {
            return mediaInfoSet;
        }

        public void setMediaInfoSet(List<MediaInfoSetResponse> mediaInfoSet) {
            this.mediaInfoSet = mediaInfoSet;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "totalCount='" + totalCount + '\'' +
                    ", requestId='" + requestId + '\'' +
                    ", mediaInfoSet=" + mediaInfoSet +
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
