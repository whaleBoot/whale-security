package com.whale.security.core.properties;

import lombok.Data;

/**
 * @ClassName SocialProperties
 * @Description TODO
 * @Author like
 * @Data 2019/8/27 14:56
 * @Version 1.0
 **/
@Data
public class SocialProperties {

    private QQProperties qq = new QQProperties();

    private WeixinProperties weixin = new WeixinProperties();

    private String filterProcessesUrl = "/auth";
}
