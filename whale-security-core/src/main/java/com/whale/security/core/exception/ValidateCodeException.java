package com.whale.security.core.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName ValidateCodeException
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 15:13
 * @Version 1.0
 **/

public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
