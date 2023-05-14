package org.cluo.framework.sdk.all.tencent.api.media.api;


import org.cluo.framework.sdk.all.tencent.api.media.BaseResponse;

import java.io.Serializable;

/**
 * In yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 12:33 2018/7/30
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class ConvertVodFileResponse extends BaseResponse implements Serializable {
    private String vodTaskId;

    public String getVodTaskId() {
        return vodTaskId;
    }

    public ConvertVodFileResponse setVodTaskId(String vodTaskId) {
        this.vodTaskId = vodTaskId;
        return this;
    }
}
