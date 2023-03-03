package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AdminClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class,args);
    }

    @RestController
    public class TestController{
        @GetMapping("/test")
        public String test1(){
            return "success";
        }
    }
}
