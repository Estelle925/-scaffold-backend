package com.yuanmeng.common.lang.exception;

/**
 * @author chenhaiming
 */
public class LockServiceException extends RuntimeException {
    public LockServiceException() {
    }

    public LockServiceException(String message) {
        super(message);
    }

    public LockServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LockServiceException(Throwable cause) {
        super(cause);
    }

    public LockServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
