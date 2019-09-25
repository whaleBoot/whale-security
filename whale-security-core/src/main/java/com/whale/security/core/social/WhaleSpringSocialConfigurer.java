package com.whale.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ClassName WhaleSpringSocialConfigurer
 * @Description TODO
 * @Author like
 * @Data 2019/9/25 10:43
 * @Version 1.0
 **/

public class WhaleSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public WhaleSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }
}
