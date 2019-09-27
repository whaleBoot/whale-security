/**
 *
 */
package com.whale.security.demo.security;

import com.whale.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 *@ClassName DemoAuthorizeConifgProvider
 *@Description TODO
 *@Author coco
 *@Data 2019/9/27 14:36
 *@Version 1.0
 **/
@Component
public class DemoAuthorizeConifgProvider implements AuthorizeConfigProvider {


    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers("/user/regist")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/user/*")
                .hasRole("ADMIN");
        //demo项目授权配置
        return false; // 返回false，表示当前配置也没有anyRequest配置
    }

}
