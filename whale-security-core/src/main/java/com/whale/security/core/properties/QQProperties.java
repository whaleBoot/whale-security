package com.whale.security.core.properties;

import lombok.Data;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.security.SocialAuthenticationProvider;

/**
 * @ClassName QQProperties
 * @Description TODO
 * @Author like
 * @Data 2019/8/27 14:54
 * @Version 1.0
 **/
@Data
public class QQProperties   {

    private String appId;

    private String appSecret;

    private String providerId = "qq";
}
