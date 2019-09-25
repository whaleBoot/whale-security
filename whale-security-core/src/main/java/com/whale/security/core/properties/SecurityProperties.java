package com.whale.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecurityProperties
 * @Description TODO
 * @Author like
 * @Data 2019/8/23 8:46
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "whale.security")
@Data
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties code = new ValidateCodeProperties();
    private SocialProperties social = new SocialProperties();
}
