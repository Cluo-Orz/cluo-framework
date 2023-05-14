package org.cluo.framework.sdk.all.tencent.api.media.api;

import org.cluo.framework.sdk.all.tencent.api.media.BaseResponse;
import org.cluo.framework.sdk.all.tencent.api.media.api.response.*;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:12 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class MediaResponse extends BaseResponse implements Serializable {
    private AiAnalysisInfo aiAnalysisInfo;
    private AnimatedGraphicsInfo animatedGraphicsInfo;
    private BasicInfo basicInfo;
    private ContentReviewInfo contentReviewInfo;
    private Drm drm;
    private ImageSpriteInfo imageSpriteInfo;
    private KeyFrameDescInfo keyFrameDescInfo;
    private MetaData metaData;
    private List<SampleSnapshotInfo> sampleSnapshotInfo;
    private SnapshotByTimeOffsetInfo snapshotByTimeOffsetInfo;
    private TranscodeInfo transcodeInfo;

    public AiAnalysisInfo getAiAnalysisInfo() {
        return aiAnalysisInfo;
    }

    public void setAiAnalysisInfo(AiAnalysisInfo aiAnalysisInfo) {
        this.aiAnalysisInfo = aiAnalysisInfo;
    }

    public AnimatedGraphicsInfo getAnimatedGraphicsInfo() {
        return animatedGraphicsInfo;
    }

    public void setAnimatedGraphicsInfo(AnimatedGraphicsInfo animatedGraphicsInfo) {
        this.animatedGraphicsInfo = animatedGraphicsInfo;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public ContentReviewInfo getContentReviewInfo() {
        return contentReviewInfo;
    }

    public void setContentReviewInfo(ContentReviewInfo contentReviewInfo) {
        this.contentReviewInfo = contentReviewInfo;
    }

    public Drm getDrm() {
        return drm;
    }

    public void setDrm(Drm drm) {
        this.drm = drm;
    }

    public ImageSpriteInfo getImageSpriteInfo() {
        return imageSpriteInfo;
    }

    public void setImageSpriteInfo(ImageSpriteInfo imageSpriteInfo) {
        this.imageSpriteInfo = imageSpriteInfo;
    }

    public KeyFrameDescInfo getKeyFrameDescInfo() {
        return keyFrameDescInfo;
    }

    public void setKeyFrameDescInfo(KeyFrameDescInfo keyFrameDescInfo) {
        this.keyFrameDescInfo = keyFrameDescInfo;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public List<SampleSnapshotInfo> getSampleSnapshotInfo() {
        return sampleSnapshotInfo;
    }

    public void setSampleSnapshotInfo(List<SampleSnapshotInfo> sampleSnapshotInfo) {
        this.sampleSnapshotInfo = sampleSnapshotInfo;
    }

    public SnapshotByTimeOffsetInfo getSnapshotByTimeOffsetInfo() {
        return snapshotByTimeOffsetInfo;
    }

    public void setSnapshotByTimeOffsetInfo(SnapshotByTimeOffsetInfo snapshotByTimeOffsetInfo) {
        this.snapshotByTimeOffsetInfo = snapshotByTimeOffsetInfo;
    }

    public TranscodeInfo getTranscodeInfo() {
        return transcodeInfo;
    }

    public void setTranscodeInfo(TranscodeInfo transcodeInfo) {
        this.transcodeInfo = transcodeInfo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MediaResponse{");
        sb.append("aiAnalysisInfo=").append(aiAnalysisInfo);
        sb.append(", animatedGraphicsInfo=").append(animatedGraphicsInfo);
        sb.append(", basicInfo=").append(basicInfo);
        sb.append(", contentReviewInfo=").append(contentReviewInfo);
        sb.append(", drm=").append(drm);
        sb.append(", imageSpriteInfo=").append(imageSpriteInfo);
        sb.append(", keyFrameDescInfo=").append(keyFrameDescInfo);
        sb.append(", metaData=").append(metaData);
        sb.append(", sampleSnapshotInfo=").append(sampleSnapshotInfo);
        sb.append(", snapshotByTimeOffsetInfo=").append(snapshotByTimeOffsetInfo);
        sb.append(", transcodeInfo=").append(transcodeInfo);
        sb.append(", code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
