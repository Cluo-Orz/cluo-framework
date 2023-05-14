package org.cluo.framework.sdk.all.tencent.api.mp;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

public class JsapiTicketRequest extends Param<JsapiTicketRequest> implements Serializable {
    public JsapiTicketRequest(HttpRequest<JsapiTicketRequest> request) {
        super(request);
    }
    private String access_token;
    private String type;

    public String getAccess_token() {
        return access_token;
    }

    public JsapiTicketRequest setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getType() {
        return type;
    }

    public JsapiTicketRequest setType(String type) {
        this.type = type;
        return this;
    }
}
