package com.whale.security.core;

import com.whale.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityCoreConfig
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 10:57
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //如果需要使用自定义密码加密解密算法，可在此return
        return new BCryptPasswordEncoder();
    }
}
