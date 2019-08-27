package com.whale.security.core.validata.code;

import com.whale.security.core.properties.SecurityProperties;
import com.whale.security.core.validata.code.image.ImageCodeGenerator;
import com.whale.security.core.validata.code.sms.DefaultSmsCodeSender;
import com.whale.security.core.validata.code.sms.SmsCodeGenerator;
import com.whale.security.core.validata.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ValidateCodeBeanConfig
 * @Description TODO
 * @Author like
 * @Data 2019/8/23 14:45
 * @Version 1.0
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

}
