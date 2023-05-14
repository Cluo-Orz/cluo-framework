package org.cluo.framework.sdk.all.tencent.api.login.wechat.mini;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * @author canfuu.cts
 * @class MiniPhoneNumberRequest
 * @date 2023/5/13 17:04
 */
public class MiniPhoneNumberRequest extends Param<MiniPhoneNumberRequest> implements Serializable {

    private String access_token;

    private String code;

    public MiniPhoneNumberRequest(HttpRequest<MiniPhoneNumberRequest> request) {
        super(request);
    }


    public String getAccess_token() {
        return access_token;
    }

    public MiniPhoneNumberRequest setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getCode() {
        return code;
    }

    public MiniPhoneNumberRequest setCode(String code) {
        this.code = code;
        return this;
    }
}
