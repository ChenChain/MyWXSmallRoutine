package com.wx.wx_routine.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author chain
 * @date 2020/5/19
 */
@RestControllerAdvice
public class WXExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(WXExceptionHandler.class);

    @ExceptionHandler(value = WXExpection.class)
    public  String bizExceptionHandler(HttpServletRequest req, WXExpection e){
        logger.error("发生业务异常！原因是：{}",e.getMessage()+"___"+req.getRequestURI());
        return e.getMessage()+"___"+req.getRequestURI();
    }

}
