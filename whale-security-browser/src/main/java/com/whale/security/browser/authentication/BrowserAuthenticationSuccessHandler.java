package com.whale.security.browser.authentication;

import com.whale.security.core.common.domain.SimpleResponse;
import com.whale.security.core.enums.LoginType;
import com.whale.security.core.properties.SecurityProperties;
import com.whale.security.core.utils.JacksonJsonUtil;
import com.whale.security.core.utils.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName BrowserAuthenticationSuccessHandler
 * @Description TODO
 * @Author like
 * @Data 2019/8/23 9:37
 * @Version 1.0
 **/
@Slf4j
@Component("browserAuthenticationSuccessHandler")
public class BrowserAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.info("登录成功");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            SimpleResponse simpleResponse = ResultVO.success("登录成功", authentication.getPrincipal(), new HashMap<>());
            try {
                response.getWriter().write(JacksonJsonUtil.obj2json(simpleResponse));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }


    }
}
