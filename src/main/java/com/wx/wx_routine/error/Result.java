package com.wx.wx_routine.error;

/**
 * 错误对象
 */
public class Result {
    public Result(String error, int code) {
        this.error = error;
        this.code = code;
    }

    /**
     * 错误内容
     */
    private String error;

    /**
     * 自定义错误码
     */
    private int code;

    /**
     * 错误码的枚举类
     */
    public enum  ErrorCode{
        /*
         *
         */
        USER_NOT_FOUND(40000),
        /**
         * 用户已存在
         */
        USER_ALREADY_EXIST(40001);

        private int code;

        public int getCode() {
            return code;
        }

        ErrorCode(int code) {
            this.code = code;
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
