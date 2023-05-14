package org.cluo.framework.sdk.exception;

/**
 * @author canfuu.cts
 * @class WechatException
 * @date 2023/5/13 10:52
 */
public class WechatException extends RuntimeException {
    public WechatException() {
        super();
    }

    public WechatException(String message) {
        super(message);
    }

    public WechatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WechatException(Throwable cause) {
        super(cause);
    }


    protected WechatException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
