package com.whale.security.core.properties;

import lombok.Data;

/**
 * @ClassName WeixinProperties
 * @Description TODO
 * @Author like
 * @Data 2019/9/25 11:45
 * @Version 1.0
 **/
@Data
public class WeixinProperties {

    private String appId;

    private String appSecret;
    
    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
     */
    private String providerId = "weixin";
}
