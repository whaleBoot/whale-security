package com.whale.security.browser;

import com.whale.security.core.common.domain.SimpleResponse;
import com.whale.security.core.properties.SecurityProperties;
import com.whale.security.core.utils.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.SecurityConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName BrowserSecurityController
 * @Description TODO
 * @Author like
 * @Data 2019/8/22 17:18
 * @Version 1.0
 **/
@RestController
@Slf4j
public class BrowserSecurityController {

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 当需要身份认证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }

        return ResultVO.error(HttpStatus.UNAUTHORIZED.value(), "访问的服务需要身份认证，请引导用户到登录页", null);
    }
}
