package org.cluo.framework.sdk.all.tencent.api.media.api;

import org.cluo.framework.sdk.all.tencent.api.media.Action;
import org.cluo.framework.sdk.all.tencent.api.media.BaseRequest;
import org.cluo.framework.sdk.all.tencent.api.media.Region;
import org.cluo.framework.sdk.support.HttpRequest;

import java.io.Serializable;
import java.util.Random;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:15 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class MediaRequest extends BaseRequest<MediaRequest> implements Serializable {
    protected String fileId;

    public MediaRequest(HttpRequest<MediaRequest> request) {
        super(request);
        Random random = new Random();
        this.setAction(Action.GetVideoInfo)
                .setNonce(random.nextInt(100000) + 10000)
                .setTimestamp(System.currentTimeMillis() / 1000)
                .setRegion(Region.bj);
    }

    public String getFileId() {
        return fileId;
    }

    public MediaRequest setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }
}
