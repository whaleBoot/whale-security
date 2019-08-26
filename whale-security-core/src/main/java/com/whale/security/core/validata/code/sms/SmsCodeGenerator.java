package com.whale.security.core.validata.code.sms;

import com.whale.security.core.properties.SecurityProperties;
import com.whale.security.core.validata.code.ValidateCodeGenerator;
import com.whale.security.core.validata.code.dto.ValidateCode;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName SmsCodeGenerator
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 15:12
 * @Version 1.0
 **/

@Data
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;


    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }


}