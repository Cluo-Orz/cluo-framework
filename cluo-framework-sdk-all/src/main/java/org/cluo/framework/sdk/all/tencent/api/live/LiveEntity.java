package org.cluo.framework.sdk.all.tencent.api.live;



import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.aggregation.entity.live
 * Create in 23:30 2018/8/4
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class LiveEntity  implements Serializable {
    protected String pushRtmp;
    protected String rtmpSD;
    protected String rtmpHD;
    protected String rtmp;
    protected String flvSD;
    protected String flvHD;
    protected String flv;
    protected String hlsSD;
    protected String hlsHD;
    protected String hls;

    public String getPushRtmp() {
        return pushRtmp;
    }

    public LiveEntity setPushRtmp(String pushRtmp) {
        this.pushRtmp = pushRtmp;
        return this;
    }

    public String getRtmpSD() {
        return rtmpSD;
    }

    public LiveEntity setRtmpSD(String rtmpSD) {
        this.rtmpSD = rtmpSD;
        return this;
    }

    public String getRtmpHD() {
        return rtmpHD;
    }

    public LiveEntity setRtmpHD(String rtmpHD) {
        this.rtmpHD = rtmpHD;
        return this;
    }

    public String getRtmp() {
        return rtmp;
    }

    public LiveEntity setRtmp(String rtmp) {
        this.rtmp = rtmp;
        return this;
    }

    public String getFlvSD() {
        return flvSD;
    }

    public LiveEntity setFlvSD(String flvSD) {
        this.flvSD = flvSD;
        return this;
    }

    public String getFlvHD() {
        return flvHD;
    }

    public LiveEntity setFlvHD(String flvHD) {
        this.flvHD = flvHD;
        return this;
    }

    public String getFlv() {
        return flv;
    }

    public LiveEntity setFlv(String flv) {
        this.flv = flv;
        return this;
    }

    public String getHlsSD() {
        return hlsSD;
    }

    public LiveEntity setHlsSD(String hlsSD) {
        this.hlsSD = hlsSD;
        return this;
    }

    public String getHlsHD() {
        return hlsHD;
    }

    public LiveEntity setHlsHD(String hlsHD) {
        this.hlsHD = hlsHD;
        return this;
    }

    public String getHls() {
        return hls;
    }

    public LiveEntity setHls(String hls) {
        this.hls = hls;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("[推流地址]").append('\n');
        sb.append("  [rtmp协议]").append(pushRtmp).append('\n');
        sb.append("[播放地址]").append('\n');
        sb.append("  [rtmp协议]").append('\n');
        sb.append("    [原画] ").append(rtmp).append('\n');
        sb.append("    [普清] ").append(rtmpSD).append('\n');
        sb.append("    [高清] ").append(rtmpHD).append('\n');
        sb.append("  [flv 协议]").append('\n');
        sb.append("    [原画] ").append(flv).append('\n');
        sb.append("    [普清] ").append(flvSD).append('\n');
        sb.append("    [高清] ").append(flvHD).append('\n');
        sb.append("  [hls 协议]").append('\n');
        sb.append("    [原画] ").append(hls).append('\n');
        sb.append("    [普清] ").append(hlsSD).append('\n');
        sb.append("    [高清] ").append(hlsHD).append('\n');

        return sb.toString();
    }
}
