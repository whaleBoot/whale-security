package com.whale.security.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName MyConstraintValidator
 * @Description TODO
 * @Author like
 * @Data 2019/8/22 11:23
 * @Version 1.0
 **/

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

   //可在此注入service

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println(value);
        return true;
    }

}
