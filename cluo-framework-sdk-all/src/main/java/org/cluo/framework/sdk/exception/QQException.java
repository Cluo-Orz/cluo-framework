package org.cluo.framework.sdk.exception;

/**
 * @author canfuu.cts
 * @class WechatException
 * @date 2023/5/13 10:52
 */
public class QQException extends RuntimeException {
    public QQException() {
        super();
    }

    public QQException(String message) {
        super(message);
    }

    public QQException(String message, Throwable cause) {
        super(message, cause);
    }

    public QQException(Throwable cause) {
        super(cause);
    }


    protected QQException(String message, Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
