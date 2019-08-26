package com.whale.security.core.validata.code.sms;

/**
 * @ClassName SmsCodeSend
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 14:52
 * @Version 1.0
 **/

public interface SmsCodeSender {

    void send(String mobile, String code);
}
