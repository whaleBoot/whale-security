package com.whale.security.core.validata.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName DefaultSmsCodeSender
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 14:54
 * @Version 1.0
 **/
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {

        log.info("向手机{}发送短信验证码{}", mobile, code);

    }
}
