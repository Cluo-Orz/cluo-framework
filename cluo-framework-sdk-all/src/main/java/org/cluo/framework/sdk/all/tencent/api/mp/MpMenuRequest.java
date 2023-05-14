package org.cluo.framework.sdk.all.tencent.api.mp;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;
import java.util.List;

public class MpMenuRequest extends Param<MpMenuRequest> implements Serializable {

    public MpMenuRequest(){
        super(null);
    }

    public MpMenuRequest(HttpRequest<MpMenuRequest> request) {
        super(request);
    }

    private List<Button> button;

    public static class Button implements Serializable{
        private Integer id;

        private String type;

        private String name;

        private String key;

        private String url;

        private String appid;

        private String pagepath;

        private String media_id;

        private List<Button> sub_button;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagepath() {
            return pagepath;
        }

        public void setPagepath(String pagepath) {
            this.pagepath = pagepath;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public List<Button> getSub_button() {
            return sub_button;
        }

        public void setSub_button(List<Button> sub_button) {
            this.sub_button = sub_button;
        }

        @Override
        public String toString() {
            return "Button{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    ", url='" + url + '\'' +
                    ", appid='" + appid + '\'' +
                    ", pagepath='" + pagepath + '\'' +
                    ", media_id='" + media_id + '\'' +
                    ", sub_button=" + sub_button +
                    '}';
        }
    }

    public List<Button> getButton() {
        return button;
    }

    public MpMenuRequest setButton(List<Button> button) {
        this.button = button;
        return this;
    }

    @Override
    public String toString() {
        return "MpMenuRequest{" +
                "button=" + button +
                '}';
    }
}
