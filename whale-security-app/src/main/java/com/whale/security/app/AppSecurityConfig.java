package com.whale.security.app;

import com.whale.security.core.constants.SecurityConstants;
import com.whale.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @ClassName AppSecurityConfig
 * @Description TODO
 * @Author like
 * @Data 2019/9/18 14:36
 * @Version 1.0
 **/
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("myUserDetailService")
    @Autowired
    private UserDetailsService myUserDetailsService;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
    }
}
