package org.cluo.framework.sdk.all.tencent.api.mp;


import java.io.Serializable;

public class MpMenuResponse implements Serializable {
    private Integer errcode;

    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public MpMenuResponse setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public MpMenuResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }
}
