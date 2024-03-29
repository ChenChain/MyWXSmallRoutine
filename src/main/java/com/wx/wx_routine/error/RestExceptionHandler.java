package com.wx.wx_routine.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class RestExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handlerResourceNotFoundException(NotFoundException e){
        logger.error(e.getMessage(),e);
        return new Result(e.getMessage(),e.getCode());
    }
}
