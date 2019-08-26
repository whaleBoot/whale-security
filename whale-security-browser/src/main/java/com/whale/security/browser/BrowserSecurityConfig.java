package com.whale.security.browser;

import com.whale.security.core.filter.ValidataCodeFilter;
import com.whale.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @ClassName BrowserSecurityConfig
 * @Description 浏览器Security配置
 * @Author like
 * @Data 2019/8/22 14:15
 * @Version 1.0
 **/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler browserAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler browserAuthenctiationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService myUserDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidataCodeFilter validataCodeFilter = new ValidataCodeFilter();
        validataCodeFilter.setAuthenticationFailureHandler(browserAuthenctiationFailureHandler);
        validataCodeFilter.setSecurityProperties(securityProperties);
        validataCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validataCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
//                .loginPage("/whale-signIn.html")
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(browserAuthenticationSuccessHandler)
                .failureHandler(browserAuthenctiationFailureHandler)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(myUserDetailService)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", "/error", "/code/*",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();


    }
}
