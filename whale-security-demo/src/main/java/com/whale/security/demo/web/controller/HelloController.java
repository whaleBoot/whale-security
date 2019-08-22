package com.whale.security.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author like
 * @Data 2019/8/22 10:12
 * @Version 1.0
 **/

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String SayHello(){

        return "HelloSecurity!!!";
    }
}
