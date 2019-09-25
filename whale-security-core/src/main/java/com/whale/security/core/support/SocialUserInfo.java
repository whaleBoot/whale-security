package com.whale.security.core.support;

import lombok.Data;

/**
 * @ClassName SocialUserInfo
 * @Description TODO
 * @Author like
 * @Data 2019/9/25 11:26
 * @Version 1.0
 **/
@Data
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;
}
