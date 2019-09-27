package com.whale.security.core.validata.code.repository;

import com.whale.security.core.validata.code.ValidateCodeType;
import com.whale.security.core.validata.code.dto.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletRequest;

/**
 * @ClassName ValidateCodeRepository
 * @Description TODO
 * @Author like
 * @Data 2019/9/27 11:04
 * @Version 1.0
 **/

public interface ValidateCodeRepository {

    void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type);

    ValidateCode get(ServletWebRequest request, ValidateCodeType type);

    void remove(ServletWebRequest request, ValidateCodeType type);


}
