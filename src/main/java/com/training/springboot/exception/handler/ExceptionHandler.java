package com.training.springboot.exception.handler;

import com.training.springboot.result.Result;
import com.training.springboot.result.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2017/12/25.
 */
@ControllerAdvice
public class ExceptionHandler {

    private static final Logger LOG = Logger.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        LOG.error("system error,",e);
        return ResultUtil.error("-1",e.getMessage());
    }

}
