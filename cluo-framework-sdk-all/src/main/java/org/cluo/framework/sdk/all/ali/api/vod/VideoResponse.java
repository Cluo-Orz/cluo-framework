package org.cluo.framework.sdk.all.ali.api.vod;

/**
 * author: yfy
 * date: 2019-03-06 19:11
 * version 1.0
 * description 描述
 */
public class VideoResponse {
    private String title;//视频标题
    private String videoUrl;//视频url路径

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
