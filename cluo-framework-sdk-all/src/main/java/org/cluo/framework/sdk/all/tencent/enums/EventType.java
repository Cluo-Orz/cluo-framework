package org.cluo.framework.sdk.all.tencent.enums;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.enums
 * Create in 13:20 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public enum EventType {
    /*
        任务流状态变更通知	ProcedureStateChanged
        视频上传完成	NewFileUpload
        URL转拉完成	PullComplete
        视频转码完成	TranscodeComplete
        视频拼接完成	ConcatComplete
        视频剪辑完成	ClipComplete
        视频截取雪碧图完成	CreateImageSpriteComplete
        视频按时间点截图完成	CreateSnapshotByTimeOffsetComplete
        视频删除完成	FileDeleted
     */
    ProcedureStateChanged,
    NewFileUpload,
    PullComplete,
    TranscodeComplete,
    ConcatComplete,
    ClipComplete,
    CreateImageSpriteComplete,
    CreateSnapshotByTimeOffsetComplete,
    FileDeleted

}
