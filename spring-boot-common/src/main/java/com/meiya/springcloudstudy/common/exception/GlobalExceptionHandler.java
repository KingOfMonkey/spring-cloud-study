package com.meiya.springcloudstudy.common.exception;

import com.meiya.springcloudstudy.common.enums.ResponseEnum;
import com.meiya.springcloudstudy.common.response.BuildResponseUtil;
import com.meiya.springcloudstudy.common.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常统一处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    private ResponseData<Object> handle(Exception e){
        String message = e.getLocalizedMessage();
        logger.error(e.getLocalizedMessage(), e);
        ResponseData response = null;
        if(e instanceof BusinessException){
            response = BuildResponseUtil.buildServiceFailResponse(message);
        }else{
            response = BuildResponseUtil.buildServerErrorResponse(ResponseEnum.SERVER_EXCEPTION.getMessage());
        }
        return response;
    }
}
