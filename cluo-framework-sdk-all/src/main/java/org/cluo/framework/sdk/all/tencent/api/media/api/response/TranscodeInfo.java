package org.cluo.framework.sdk.all.tencent.api.media.api.response;


import java.io.Serializable;
import java.util.List;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:13 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class TranscodeInfo {
    private Integer idrAlignment;
    private List<TranscodeList> transcodeList;

    public static class TranscodeList implements Serializable {
        private String url;
        private Integer definition;
        private Integer bitrate;
        private Integer height;
        private Integer width;
        private Integer size;
        private Integer duration;
        private Float floatDuration;
        private String container;
        private String md5;
        List<MetaData.AudioStream> audioStreamList;
        List<MetaData.VideoStream> videoStreamList;

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("TranscodeList{");
            sb.append("url='").append(url).append('\'');
            sb.append(", definition=").append(definition);
            sb.append(", bitrate=").append(bitrate);
            sb.append(", height=").append(height);
            sb.append(", width=").append(width);
            sb.append(", size=").append(size);
            sb.append(", duration=").append(duration);
            sb.append(", floatDuration=").append(floatDuration);
            sb.append(", container='").append(container).append('\'');
            sb.append(", md5='").append(md5).append('\'');
            sb.append(", audioStreamList=").append(audioStreamList);
            sb.append(", videoStreamList=").append(videoStreamList);
            sb.append('}');
            return sb.toString();
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getDefinition() {
            return definition;
        }

        public void setDefinition(Integer definition) {
            this.definition = definition;
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

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public Float getFloatDuration() {
            return floatDuration;
        }

        public void setFloatDuration(Float floatDuration) {
            this.floatDuration = floatDuration;
        }

        public String getContainer() {
            return container;
        }

        public void setContainer(String container) {
            this.container = container;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public List<MetaData.AudioStream> getAudioStreamList() {
            return audioStreamList;
        }

        public void setAudioStreamList(List<MetaData.AudioStream> audioStreamList) {
            this.audioStreamList = audioStreamList;
        }

        public List<MetaData.VideoStream> getVideoStreamList() {
            return videoStreamList;
        }

        public void setVideoStreamList(List<MetaData.VideoStream> videoStreamList) {
            this.videoStreamList = videoStreamList;
        }
    }

    public Integer getIdrAlignment() {
        return idrAlignment;
    }

    public void setIdrAlignment(Integer idrAlignment) {
        this.idrAlignment = idrAlignment;
    }

    public List getTranscodeList() {
        return transcodeList;
    }

    public void setTranscodeList(List transcodeList) {
        this.transcodeList = transcodeList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TranscodeInfo{");
        sb.append("idrAlignment=").append(idrAlignment);
        sb.append(", transcodeList=").append(transcodeList);
        sb.append('}');
        return sb.toString();
    }
}
