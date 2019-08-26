package com.whale.security.core.validata.code;


import com.whale.security.core.constants.SecurityConstants;

/**
 * @ClassName ValidateCodeType
 * @Description TODO
 * @Author like
 * @Data 2019/8/26 15:27
 * @Version 1.0
 **/

public enum ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     *
     * @return
     */
    public abstract String getParamNameOnValidate();

}

