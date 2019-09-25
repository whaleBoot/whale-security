package com.whale.security.core.authentication;

import com.whale.security.core.constants.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @ClassName AbstractChannelSecurityConfig
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 17:53
 * @Version 1.0
 **/

public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler whaleAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler whaleAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
//                登录页面html  需要登录时重定向到此url
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
//                登录时，表单提交请求url
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(whaleAuthenticationSuccessHandler)
                .failureHandler(whaleAuthenticationFailureHandler);
    }

}
