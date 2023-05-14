package org.cluo.framework.sdk.all.tencent.api.media.api.response;



import java.io.Serializable;
import java.util.List;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity
 * Create in 15:10 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */

public class MetaData  implements Serializable {
    private Integer size;
    private String container;
    private Integer bitrate;
    private Integer height;
    private Integer width;
    private String md5;
    private Integer duration;
    private Integer rotate;
    private List<VideoStream> videoStreamList;

    public static class VideoStream implements Serializable {
        private Integer bitrate;
        private Integer height;
        private Integer width;
        private String codec;
        private Integer fps;

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("VideoStream{");
            sb.append("bitrate=").append(bitrate);
            sb.append(", height=").append(height);
            sb.append(", width=").append(width);
            sb.append(", codec='").append(codec).append('\'');
            sb.append(", fps=").append(fps);
            sb.append('}');
            return sb.toString();
        }

        public Integer getBitrate() {
            return bitrate;
        }

        public void setBitrate(Integer bitrate) {
            this.bitrate = bitrate;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public String getCodec() {
            return codec;
        }

        public void setCodec(String codec) {
            this.codec = codec;
        }

        public Integer getFps() {
            return fps;
        }

        public void setFps(Integer fps) {
            this.fps = fps;
        }
    }

    private List<AudioStream> audioStreamList;

    public static class AudioStream implements Serializable {
        private Integer bitrate;
        private Integer samplingRate;
        private String codec;

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("AudioStream{");
            sb.append("bitrate=").append(bitrate);
            sb.append(", samplingRate=").append(samplingRate);
            sb.append(", codec='").append(codec).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public Integer getBitrate() {
            return bitrate;
        }

        public void setBitrate(Integer bitrate) {
            this.bitrate = bitrate;
        }

        public Integer getSamplingRate() {
            return samplingRate;
        }

        public void setSamplingRate(Integer samplingRate) {
            this.samplingRate = samplingRate;
        }

        public String getCodec() {
            return codec;
        }

        public void setCodec(String codec) {
            this.codec = codec;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MetaData{");
        sb.append("size=").append(size);
        sb.append(", container='").append(container).append('\'');
        sb.append(", bitrate=").append(bitrate);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", md5='").append(md5).append('\'');
        sb.append(", duration=").append(duration);
        sb.append(", rotate=").append(rotate);
        sb.append(", videoStreamList=").append(videoStreamList);
        sb.append(", audioStreamList=").append(audioStreamList);
        sb.append('}');
        return sb.toString();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Integer getBitrate() {
        return bitrate;
    }

    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRotate() {
        return rotate;
    }

    public void setRotate(Integer rotate) {
        this.rotate = rotate;
    }

    public List<VideoStream> getVideoStreamList() {
        return videoStreamList;
    }

    public void setVideoStreamList(List<VideoStream> videoStreamList) {
        this.videoStreamList = videoStreamList;
    }

    public List<AudioStream> getAudioStreamList() {
        return audioStreamList;
    }

    public void setAudioStreamList(List<AudioStream> audioStreamList) {
        this.audioStreamList = audioStreamList;
    }

}
