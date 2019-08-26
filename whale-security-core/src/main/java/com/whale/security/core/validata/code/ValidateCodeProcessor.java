package com.whale.security.core.validata.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeProcessor
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 15:24
 * @Version 1.0
 **/

public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);

}