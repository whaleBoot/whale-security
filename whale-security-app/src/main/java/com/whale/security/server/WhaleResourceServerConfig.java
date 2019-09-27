package com.whale.security.server;

import com.whale.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
import com.whale.security.core.authentication.FormAuthenticationConfig;
import com.whale.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.whale.security.core.authorize.WhaleAuthorizeConfigManager;
import com.whale.security.core.constants.SecurityConstants;
import com.whale.security.core.properties.SecurityProperties;
import com.whale.security.core.validata.code.ValidateCodeSecurityConfig;
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
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private WhaleAuthorizeConfigManager whaleAuthorizeConfigManager;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;


    @Override
    public void configure(HttpSecurity http) throws Exception {


        formAuthenticationConfig.configure(http);

        http.apply(validateCodeSecurityConfig)
                    .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                    .and()
                .apply(whaleSocialSecurityConfig)
                .   and()
                .apply(openIdAuthenticationSecurityConfig)
                    .and()
                .csrf().disable();
        whaleAuthorizeConfigManager.config(http.authorizeRequests());

    }
}
