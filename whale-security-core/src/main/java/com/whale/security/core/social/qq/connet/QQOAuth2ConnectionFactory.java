package com.whale.security.core.social.qq.connet;

import com.whale.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @ClassName QQConnectionFactory
 * @Description
 * @Author like
 * @Data 2019/8/27 14:27
 * @Version 1.0
 **/

public class QQOAuth2ConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQOAuth2ConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
