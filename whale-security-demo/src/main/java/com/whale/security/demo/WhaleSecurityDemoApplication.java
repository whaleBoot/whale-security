package com.whale.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "com.whale.security")
public class WhaleSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleSecurityDemoApplication.class, args);
    }

}
