package org.cluo.framework.sdk.all.tencent.api.media.api;


import org.cluo.framework.sdk.all.tencent.api.media.Action;
import org.cluo.framework.sdk.all.tencent.api.media.BaseRequest;
import org.cluo.framework.sdk.all.tencent.api.media.Region;
import org.cluo.framework.sdk.support.HttpRequest;

import java.io.Serializable;
import java.util.Random;

/**
 * In yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media.request
 * Create in 12:20 2018/7/30
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class ConvertVodFileRequest extends BaseRequest<ConvertVodFileRequest> implements Serializable {
    protected String fileId;
    protected Integer isScreenshot;
    protected Integer isWatermark;

    public ConvertVodFileRequest(HttpRequest request) {
        super(request);
        Random random = new Random();
        this.setAction(Action.ConvertVodFile)
                .setNonce(random.nextInt(100000) + 10000)
                .setTimestamp(System.currentTimeMillis() / 1000)
                .setRegion(Region.bj);
    }

    public Integer getIsScreenshot() {
        return isScreenshot;
    }

    public ConvertVodFileRequest setIsScreenshot(Integer isScreenshot) {
        this.isScreenshot = isScreenshot;
        return this;
    }

    public String getFileId() {
        return fileId;
    }

    public ConvertVodFileRequest setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    public Integer getIsWatermark() {
        return isWatermark;
    }

    public ConvertVodFileRequest setIsWatermark(Integer isWatermark) {
        this.isWatermark = isWatermark;
        return this;
    }
}
