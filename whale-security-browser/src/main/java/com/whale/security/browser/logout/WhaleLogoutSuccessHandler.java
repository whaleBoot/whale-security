package com.whale.security.browser.logout;

import com.whale.security.core.exception.CustomException;
import com.whale.security.core.support.SimpleResponse;
import com.whale.security.core.utils.JacksonJsonUtil;
import com.whale.security.core.utils.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName WhaleLogoutSuccessHandler
 * @Description TODO
 * @Author like
 * @Data 2019/9/26 16:30
 * @Version 1.0
 **/
@Slf4j
public class WhaleLogoutSuccessHandler implements LogoutSuccessHandler {

    private String signOutUrl;

    public WhaleLogoutSuccessHandler(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("退出成功");

        if (StringUtils.isBlank(signOutUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            SimpleResponse simpleResponse = ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "success logout", new HashMap<>());
            try {
                response.getWriter().write(JacksonJsonUtil.obj2json(simpleResponse));
            } catch (Exception e) {
                throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "数据转换异常");
            }
        } else {
            response.sendRedirect(request.getContextPath()+signOutUrl);
        }

    }
}
