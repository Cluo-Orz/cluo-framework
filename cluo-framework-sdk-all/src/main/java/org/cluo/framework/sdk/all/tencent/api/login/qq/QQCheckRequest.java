package org.cluo.framework.sdk.all.tencent.api.login.qq;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.login.qq
 * Create in 00:55 2018/8/17
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class QQCheckRequest extends Param<QQCheckRequest> implements Serializable {
    private String access_token;
    private String unionid;

    public QQCheckRequest(HttpRequest<QQCheckRequest> request) {
        super(request);
    }

    public String getAccess_token() {
        return access_token;
    }

    public QQCheckRequest setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getUnionid() {
        return unionid;
    }

    public QQCheckRequest setUnionid(String unionid) {
        this.unionid = unionid;
        return this;
    }
}
