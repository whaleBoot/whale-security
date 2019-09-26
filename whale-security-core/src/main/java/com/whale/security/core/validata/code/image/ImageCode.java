package com.whale.security.core.validata.code.image;

import com.whale.security.core.validata.code.dto.ValidateCode;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @ClassName ImageCode
 * @Description 图形验证码
 * @Author like
 * @Data 2019/1/21 17:48
 * @Version 1.0
 **/
public class ImageCode extends ValidateCode {

    private static final long serialVersionUID = -2073564589081660394L;
    private BufferedImage image;


    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
