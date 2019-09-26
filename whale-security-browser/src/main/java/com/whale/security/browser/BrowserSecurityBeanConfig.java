package com.whale.security.browser;

import com.whale.security.browser.logout.WhaleLogoutSuccessHandler;
import com.whale.security.browser.session.WhaleExpiredSessionStrategy;
import com.whale.security.browser.session.WhaleInvalidSessionStrategy;
import com.whale.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @ClassName BrowserSecurityBeanConfig
 * @Description TODO
 * @Author like
 * @Data 2019/9/25 16:26
 * @Version 1.0
 **/
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new WhaleInvalidSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new WhaleExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler LogoutSuccessHandler() {
        return new WhaleLogoutSuccessHandler(securityProperties.getBrowser().getSignOutUrl());
    }
}
