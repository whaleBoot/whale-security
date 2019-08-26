package com.whale.security.core.validata.code;

import com.whale.security.core.validata.code.dto.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeGenerator
 * @Description TODO
 * @Author like
 * @Data 2019/8/23 14:37
 * @Version 1.0
 **/

public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
