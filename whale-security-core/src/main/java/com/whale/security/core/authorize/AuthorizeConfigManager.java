package com.whale.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 授权信息管理器
 * <p>
 * 用于收集系统中所有 AuthorizeConfigProvider 并加载其配置
 *
 * @author zhangyang
 */

/**
 * @ClassName AuthorizeConfigManager
 * @Description 授权信息管理器
 * 用于收集系统中所有 AuthorizeConfigProvider 并加载其配置
 * @Author coco
 * @Data 2019/9/27 14:27
 * @Version 1.0
 **/
public interface AuthorizeConfigManager {

    /**
     * @param config
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
