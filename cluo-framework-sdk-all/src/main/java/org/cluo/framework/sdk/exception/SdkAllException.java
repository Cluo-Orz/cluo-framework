package org.cluo.framework.sdk.exception;

/**
 * @author canfuu.cts
 * @class WechatException
 * @date 2023/5/13 10:52
 */
public class SdkAllException extends RuntimeException {
    public SdkAllException() {
        super();
    }

    public SdkAllException(String message) {
        super(message);
    }

    public SdkAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public SdkAllException(Throwable cause) {
        super(cause);
    }


    protected SdkAllException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
