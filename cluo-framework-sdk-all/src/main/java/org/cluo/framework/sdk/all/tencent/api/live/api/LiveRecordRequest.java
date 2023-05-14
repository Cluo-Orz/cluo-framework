package org.cluo.framework.sdk.all.tencent.api.live.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.media.Action;
import org.cluo.framework.sdk.all.tencent.api.media.BaseRequest;
import org.cluo.framework.sdk.support.HttpRequest;

import java.io.Serializable;
import java.util.Random;

/**
 * Create in 15:15 2018/7/13
 *
 * @author thone
 * @version v1.0
 * descriotion 创建直播录制任务的请求类
 */
public class LiveRecordRequest extends BaseRequest<LiveRecordRequest> implements Serializable {
    // 流名称。
    @JsonProperty("StreamName")
    protected String streamName;
    // 推流路径，与推流和播放地址中的AppName保持一致，默认为 live。
    @JsonProperty("AppName")
    protected String appName;
    // 推流域名。多域名推流必须设置。
    @JsonProperty("DomainName")
    protected String domainName;
    // 录制开始时间。中国标准时间，需要URLEncode。如 2017-01-01 10:10:01，
    // 编码为：2017-01-01+10%3a10%3a01。定时录制模式，必须设置该字段；实时视频录制模式，忽略该字段。
    @JsonProperty("StartTime")
    protected String startTime;
    // 录制结束时间。中国标准时间，需要URLEncode。如 2017-01-01 10:30:01，编码为：2017-01-01+10%3a30%3a01。
    // 定时录制模式，必须设置该字段；实时录制模式，为可选字段。如果通过Highlight参数，设置录制为实时视频录制模式，
    // 其设置的结束时间不应超过当前时间+30分钟，如果设置的结束时间超过当前时间+30分钟或者小于当前时间或者不设置该参数，则实际结束时间为当前时间+30分钟。
    @JsonProperty("EndTime")
    protected String endTime;
    //录制类型。
    //“video” : 音视频录制【默认】。
    //“audio” : 纯音频录制。
    //在定时录制模式或实时视频录制模式下，该参数均有效，不区分大小写。
    @JsonProperty("RecordType")
    protected String recordType;
    //录制文件格式。其值为：
    //“flv”,“hls”,”mp4”,“aac”,”mp3”，默认“flv”。
    //在定时录制模式或实时视频录制模式下，该参数均有效，不区分大小写。
    @JsonProperty("FileFormat")
    protected String fileFormat;
    //开启实时视频录制模式标志。0：不开启实时视频录制模式，即采用定时录制模式【默认】；1：开启实时视频录制模式。
    @JsonProperty("Highlight")
    protected Integer highlight;
    //开启A+B=C混流C流录制标志。0：不开启A+B=C混流C流录制【默认】；1：开启A+B=C混流C流录制。
    //在定时录制模式或实时视频录制模式下，该参数均有效。
    @JsonProperty("MixStream")
    protected Integer mixStream;
    //录制流参数。当前支持以下参数：
    //record_interval - 录制分片时长，单位 秒，1800 - 7200
    //storage_time - 录制文件存储时长，单位 秒
    //eg. record_interval=3600&storage_time=2592000
    //注：参数需要url encode。
    //在定时录制模式或实时视频录制模式下，该参数均有效。
    @JsonProperty("StreamParam")
    protected String streamParam;

    public LiveRecordRequest(HttpRequest<LiveRecordRequest> request) {
        super(request);
        Random random = new Random();
        this.setAction(Action.CreateLiveRecord)
                .setNonce(random.nextInt(100000) + 10000)
                .setTimestamp(System.currentTimeMillis() / 1000)
                .setVersion("2018-08-01");
    }

    public String getStreamName() {
        return streamName;
    }

    public LiveRecordRequest setStreamName(String streamName) {
        this.streamName = streamName;
        return this;
    }

    public String getAppName() {
        return appName;
    }

    public LiveRecordRequest setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public String getDomainName() {
        return domainName;
    }

    public LiveRecordRequest setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public LiveRecordRequest setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public LiveRecordRequest setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getRecordType() {
        return recordType;
    }

    public LiveRecordRequest setRecordType(String recordType) {
        this.recordType = recordType;
        return this;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public LiveRecordRequest setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
        return this;
    }

    public Integer getHighlight() {
        return highlight;
    }

    public LiveRecordRequest setHighlight(Integer highlight) {
        this.highlight = highlight;
        return this;
    }

    public Integer getMixStream() {
        return mixStream;
    }

    public LiveRecordRequest setMixStream(Integer mixStream) {
        this.mixStream = mixStream;
        return this;
    }

    public String getStreamParam() {
        return streamParam;
    }

    public LiveRecordRequest setStreamParam(String streamParam) {
        this.streamParam = streamParam;
        return this;
    }
}
