package com.wx.wx_routine.error;

/**
 * 专门用于表示各种类型资源不存在的异常情况
 */
public class NotFoundException  extends  GlobalException {
    public NotFoundException(String msg, int code) {
        super(msg, code);
    }
}
