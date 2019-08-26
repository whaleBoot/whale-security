package com.whale.security.core.properties;

import lombok.Data;

/**
 * @ClassName ValidataCodeProperties
 * @Description TODO
 * @Author like
 * @Data 2019/2/20 16:39
 * @Version 1.0
 **/
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();
    private SmsCodeProperties sms = new SmsCodeProperties();

}
