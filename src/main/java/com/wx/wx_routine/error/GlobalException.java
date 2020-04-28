package com.wx.wx_routine.error;

/**
 * 全局异常处理
 */
public class GlobalException extends Exception {
    private int code;

    public GlobalException(String msg){
        super(msg);
    }

    public GlobalException(String msg, int code){
        super(msg);
        this.code=code;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
