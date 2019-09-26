package com.whale.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName WhaleExpiredSessionStrategy
 * @Description TODO
 * @Author like
 * @Data 2019/9/25 15:31
 * @Version 1.0
 **/

public class WhaleExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public WhaleExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }


    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }

}