package com.whale.security.browser.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * @ClassName WhaleInvalidSessionStrategy
 * @Description TODO
 * @Author like
 * @Data 2019/9/25 15:35
 * @Version 1.0
 **/

public class WhaleInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

    public WhaleInvalidSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        onSessionInvalid(request, response);
    }

}
