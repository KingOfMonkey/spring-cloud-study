package com.meiya.springcloudstudy.common.exception;

public class BusinessException extends RuntimeException{

    private BusinessException() {
        // 私有构造
    }

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
