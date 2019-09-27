package com.whale.security.app.validate.code.impl;

import com.whale.security.core.exception.ValidateCodeException;
import com.whale.security.core.utils.RedisUtils;
import com.whale.security.core.validata.code.ValidateCodeType;
import com.whale.security.core.validata.code.dto.ValidateCode;
import com.whale.security.core.validata.code.repository.ValidateCodeRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName RedisValidateCodeRepository
 * @Description 基于redis的验证码存取器，避免由于没有session导致无法存取验证码的问题
 * @Author like
 * @Data 2019/9/27 11:21
 * @Version 1.0
 **/
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisCacheManager;


    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
//        redisTemplate.opsForValue().set(buildKey(request, type), code, 30, TimeUnit.MINUTES);
        redisCacheManager.set(buildKey(request,type),code,300);

    }


    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, type));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }


    @Override
    public void remove(ServletWebRequest request, ValidateCodeType type) {
        redisTemplate.delete(buildKey(request, type));
    }

    /**
     * @param request
     * @param type
     * @return
     */
    private String buildKey(ServletWebRequest request, ValidateCodeType type) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        return "code:" + type.toString().toLowerCase() + ":" + deviceId;
    }

}
