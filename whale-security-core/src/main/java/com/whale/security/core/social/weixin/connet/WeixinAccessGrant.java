package com.whale.security.core.social.weixin.connet;

import lombok.Data;
import org.springframework.social.oauth2.AccessGrant;

/**
 * @ClassName WeixinAccessGrant
 * @Description 微信的access_token信息。与标准OAuth2协议不同，微信在获取access_token时会同时返回openId,并没有单独的通过accessToke换取openId的服务
 * 所以在这里继承了标准AccessGrant，添加了openId字段，作为对微信access_token信息的封装。
 * @Author like
 * @Data 2019/9/25 13:48
 * @Version 1.0
 **/
@Data
public class WeixinAccessGrant extends AccessGrant {


    private static final long serialVersionUID = -8847985890935335076L;

    private String openId;

    public WeixinAccessGrant() {
        super("");
    }

    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }
}
