package org.cluo.framework.sdk.all.tencent.api.media.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.media.Action;
import org.cluo.framework.sdk.all.tencent.api.media.BaseRequest;
import org.cluo.framework.sdk.support.HttpRequest;

import java.io.Serializable;
import java.util.Random;

/**
 * @author: thone
 * time: 2019/6/2 下午1:32
 * desc: //TODO
 **/
public class SearchMediaRequest extends BaseRequest<SearchMediaRequest> implements Serializable {
    @JsonProperty("Text")
    protected String text;

    public SearchMediaRequest(HttpRequest<SearchMediaRequest> request) {
        super(request);
        Random random = new Random();
        this.setAction(Action.SearchMedia)
                .setNonce(random.nextInt(100000) + 10000)
                .setTimestamp(System.currentTimeMillis() / 1000)
                .setVersion("2018-07-17");
    }

    public String getText() {
        return text;
    }

    public SearchMediaRequest setText(String text) {
        this.text = text;
        return this;
    }
}
