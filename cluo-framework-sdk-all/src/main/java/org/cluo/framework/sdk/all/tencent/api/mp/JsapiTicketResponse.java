package org.cluo.framework.sdk.all.tencent.api.mp;


import java.io.Serializable;

public class JsapiTicketResponse implements Serializable {
    private String ticket;
    private Long expires_in;
    private Long errcode;
    private String errmsg;

    public String getTicket() {
        return ticket;
    }

    public JsapiTicketResponse setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public JsapiTicketResponse setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public Long getErrcode() {
        return errcode;
    }

    public JsapiTicketResponse setErrcode(Long errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public JsapiTicketResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }
}
