package com.whale.security.core.validata.code.dto;

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
@Data
public class ValidateCode {


    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
