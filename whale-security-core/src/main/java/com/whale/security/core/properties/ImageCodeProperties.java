package com.whale.security.core.properties;

import com.whale.security.core.validata.code.sms.SmsCodeSender;
import lombok.Data;

/**
 * @ClassName ImageCodeProperties
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 16:37
 * @Version 1.0
 **/

@Data
public class ImageCodeProperties extends SmsCodeProperties {

    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 80;
    private int height = 30;
    private int lineCount;

    /* 用于指明哪些服务需要引用验证码校验. */
    private String url;
}
