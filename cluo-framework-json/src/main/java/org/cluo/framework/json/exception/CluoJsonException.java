package org.cluo.framework.json.exception;

/**
 * @author canfuu.cts
 * @class WechatException
 * @date 2023/5/13 10:52
 */
public class CluoJsonException extends RuntimeException {
    public CluoJsonException() {
        super();
    }

    public CluoJsonException(String message) {
        super(message);
    }

    public CluoJsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CluoJsonException(Throwable cause) {
        super(cause);
    }


    protected CluoJsonException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
