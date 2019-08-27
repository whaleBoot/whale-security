package com.whale.security.core.handle;


import com.whale.security.core.support.SimpleResponse;
import com.whale.security.core.exception.CustomException;
import com.whale.security.core.utils.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@CrossOrigin
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public SimpleResponse runtimeExceptionHandler(RuntimeException ex, HttpServletRequest request) {
        return exceptionFormat(1, ex, request);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public SimpleResponse nullPointerExceptionHandler(NullPointerException ex, HttpServletRequest request) {
        return exceptionFormat(2, ex, request);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public SimpleResponse classCastExceptionHandler(ClassCastException ex, HttpServletRequest request) {
        return exceptionFormat(3, ex, request);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public SimpleResponse iOExceptionHandler(IOException ex, HttpServletRequest request) {
        return exceptionFormat(4, ex, request);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public SimpleResponse noSuchMethodExceptionHandler(NoSuchMethodException ex, HttpServletRequest request) {
        return exceptionFormat(5, ex, request);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public SimpleResponse indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex, HttpServletRequest request) {
        return exceptionFormat(6, ex, request);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public SimpleResponse requestNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        System.out.println("400..requestNotReadable");
        return exceptionFormat(7, ex, request);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public SimpleResponse requestTypeMismatch(TypeMismatchException ex, HttpServletRequest request) {
        System.out.println("400..TypeMismatchException");
        return exceptionFormat(8, ex, request);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public SimpleResponse requestMissingServletRequest(MissingServletRequestParameterException ex, HttpServletRequest request) {
        System.out.println("400..MissingServletRequest");
        return exceptionFormat(9, ex, request);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public SimpleResponse request405(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        return exceptionFormat(10, ex, request);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public SimpleResponse request406(HttpMediaTypeNotAcceptableException ex, HttpServletRequest request) {
        System.out.println("406...");
        return exceptionFormat(11, ex, request);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public SimpleResponse server500(RuntimeException ex, HttpServletRequest request) {
        System.out.println("500...");
        return exceptionFormat(12, ex, request);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public SimpleResponse requestStackOverflow(StackOverflowError ex, HttpServletRequest request) {
        return exceptionFormat(13, ex, request);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public SimpleResponse exception(Exception ex, HttpServletRequest request) {
        return exceptionFormat(14, ex, request);
    }


    @ExceptionHandler({CustomException.class})
    public SimpleResponse customException(CustomException ex, HttpServletRequest request) {
        return customExceptionFormat(ex.getErrorCode(), ex.getErrorMessage(), request);
    }



    private <T extends Throwable> SimpleResponse exceptionFormat(Integer code, T ex, HttpServletRequest request) {
        log.error(String.format(logExceptionFormat, code, ex.getMessage()));
        return ResultVO.error(code,ex.getMessage(),new HashMap<>());
    }

    private <T extends Throwable> SimpleResponse customExceptionFormat(Integer code, String msg, HttpServletRequest request) {
        log.error(String.format(logExceptionFormat, code, msg));
        return ResultVO.error(code,msg,new HashMap<>());
    }

}
