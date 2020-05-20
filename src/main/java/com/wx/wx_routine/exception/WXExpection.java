package com.wx.wx_routine.exception;

/**
 * TODO
 *
 * @author chain
 * @date 2020/5/19
 */
public class WXExpection extends RuntimeException {
    public WXExpection() {
    }

    public WXExpection(String message) {
        super(message);
    }

    public WXExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public WXExpection(Throwable cause) {
        super(cause);
    }

    public WXExpection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
