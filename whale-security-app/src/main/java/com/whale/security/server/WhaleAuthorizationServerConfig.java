package com.whale.security.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @ClassName whaleAuthorizationServerConfig
 * @Description TODO
 * @Author like
 * @Data 2019/9/18 9:17
 * @Version 1.0
 **/
@Configuration
@EnableAuthorizationServer
public class WhaleAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
              /* secret密码配置从 Spring Security 5.0开始必须以 {加密方式}+加密后的密码 这种格式填写

                    当前版本5新增支持加密方式：
                    bcrypt - BCryptPasswordEncoder (Also used for encoding)
                    ldap - LdapShaPasswordEncoder
                    MD4 - Md4PasswordEncoder
                    MD5 - new MessageDigestPasswordEncoder("MD5")
                    noop - NoOpPasswordEncoder
                    pbkdf2 - Pbkdf2PasswordEncoder
                    scrypt - SCryptPasswordEncoder
                    SHA-1 - new MessageDigestPasswordEncoder("SHA-1")
                    SHA-256 - new MessageDigestPasswordEncoder("SHA-256")
                    sha256 - StandardPasswordEncoder
                 */
        clients.inMemory()
                .withClient("whale")
                .secret("{noop}" + "whaleSecret")
                .scopes("all")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .redirectUris("http://example.com")
                .autoApprove(false);

    }


}
