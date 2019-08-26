package com.whale.security.browser.authentication;

import com.whale.security.core.common.domain.SimpleResponse;
import com.whale.security.core.enums.LoginType;
import com.whale.security.core.properties.SecurityProperties;
import com.whale.security.core.utils.JacksonJsonUtil;
import com.whale.security.core.utils.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName BrowserAuthenctiationFailureHandler
 * @Description TODO
 * @Author like
 * @Data 2019/8/23 9:37
 * @Version 1.0
 **/
@Slf4j
@Component("browserAuthenctiationFailureHandler")
public class BrowserAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            SimpleResponse simpleResponse = ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), new HashMap<>());
            try {
                response.getWriter().write(JacksonJsonUtil.obj2json(simpleResponse));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
