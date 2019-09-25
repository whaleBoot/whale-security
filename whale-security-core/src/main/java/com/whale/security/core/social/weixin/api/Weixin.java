package com.whale.security.core.social.weixin.api;

/**
 * @ClassName Weixin
 * @Description 微信API调用接口
 * @Author like
 * @Data 2019/9/25 13:41
 * @Version 1.0
 **/

public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);
}
