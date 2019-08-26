package com.whale.security.demo;

import com.whale.security.core.properties.SecurityProperties;
import com.whale.security.core.utils.ValidateCodeUtil;
import com.whale.security.core.validata.code.ValidateCodeGenerator;
import com.whale.security.core.validata.code.image.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName DemoImageCodeGenerator
 * @Description TODO
 * @Author like
 * @Data 2019/8/23 15:03
 * @Version 1.0
 **/
@Component("imageValidateCodeGeneratorDemo")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(ServletWebRequest request) {
        int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height", securityProperties.getCode().getImage().getHeight());
        ValidateCodeUtil vCode = new ValidateCodeUtil(200, height, 6, securityProperties.getCode().getImage().getLineCount());
        return new ImageCode(vCode.getBuffImg(), vCode.getCode(), securityProperties.getCode().getImage().getExpireIn());
    }
}
