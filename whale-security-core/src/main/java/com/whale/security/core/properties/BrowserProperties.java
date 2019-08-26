package com.whale.security.core.properties;

import com.whale.security.core.enums.LoginType;
import lombok.Data;

/**
 * @ClassName BrowserProperties
 * @Description TODO
 * @Author like
 * @Data 2019/8/23 8:46
 * @Version 1.0
 **/
@Data
public class BrowserProperties {

    private String loginPage = "/whale-signIn.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;
}
