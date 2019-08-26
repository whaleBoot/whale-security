package com.whale.security.core.validata.code.image;

import com.whale.security.core.validata.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @ClassName ImageCodeProcessor
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 16:04
 * @Version 1.0
 **/

@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }

}
