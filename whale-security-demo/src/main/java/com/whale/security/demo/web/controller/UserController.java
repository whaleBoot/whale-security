package com.whale.security.demo.web.controller;

import com.whale.security.demo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author like
 * @Data 2019/8/22 10:52
 * @Version 1.0
 **/
@RestController
public class UserController {


    @GetMapping("/user")
    public List<User> query() {

        return null;
    }


}
