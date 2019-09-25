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
 * @Description
 * @Author like
 * @Data 2019/8/23 14:45
 * @Version 1.0
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 方法名就是bean名
     * <p>
     * 等同于在ImageCodeGenerator中使用注解@Component
     * <p>
     * ConditionalOnMissingBean 在初始化bean之前，会先在spring容器中查找是否已经有name为imageValidateCodeGenerator的bean
     * 如果有则不会用return的bean，而是用查找到的bean，以此实现bean覆盖，业务逻辑自定义。
     *
     * @return ValidateCodeGenerator
     */
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
