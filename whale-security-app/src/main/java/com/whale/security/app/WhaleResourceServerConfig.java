package com.whale.security.app;

import com.whale.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.whale.security.core.constants.SecurityConstants;
import com.whale.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ClassName WhaleResourceServerConfig
 * @Description TODO
 * @Author like
 * @Data 2019/9/18 13:40
 * @Version 1.0
 **/
@Configuration
@EnableResourceServer
public class WhaleResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    protected AuthenticationSuccessHandler whaleAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler whaleAuthenticationFailureHandler;

    @Autowired
    private SpringSocialConfigurer whaleSocialSecurityConfig;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
//                登录页面html
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
//                登录时，表单提交请求url
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(whaleAuthenticationSuccessHandler)
                .failureHandler(whaleAuthenticationFailureHandler);

        http//.apply(validateCodeSecurityConfig)
                // .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(whaleSocialSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getSignUpUrl(),
                        "/user/regist").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();

    }
}
