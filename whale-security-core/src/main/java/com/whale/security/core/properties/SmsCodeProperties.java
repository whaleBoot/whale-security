package com.whale.security.core.properties;

import lombok.Data;

/**
 * @ClassName SmsCodeProperties
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 15:14
 * @Version 1.0
 **/
@Data
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 300;

    private String url;
}
