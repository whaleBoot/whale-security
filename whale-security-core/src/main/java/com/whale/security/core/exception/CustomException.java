package com.whale.security.core.exception;

import lombok.Data;

/**
 * @ClassName CustomException
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 16:01
 * @Version 1.0
 **/

@Data
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -6114700933498491185L;

    private Integer errorCode;
    private String errorMessage;

    public CustomException() {
    }

    public CustomException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CustomException(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
