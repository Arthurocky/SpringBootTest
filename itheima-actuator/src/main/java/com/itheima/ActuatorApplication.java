package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ActuatorApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    @RestController
    public class TestController {

        @GetMapping("/test")
        public String test1()
        {
            return "success";
        }
    }

    //Actuator是springboot自带的组件可以用来进行监控，Bean加载情况、环境变量、日志信息、线程信息等等，使用简单
    /*
    使用actuator
    (1)操作步骤：
        1.创建springboot工程  -->itheima-actuator
        2.添加Actuator的起步依赖
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-actuator</artifactId>
            </dependency>
        3.配置开启端点和相关配置项
            配置application.properties:
            # 配置健康端点开启所有详情信息
            management.endpoint.health.show-details=always
            # 设置开放所有web相关的端点信息
            management.endpoints.web.exposure.include=*
            # 设置info前缀的信息设置
            info.name=zhangsan
            info.age=18
        4.通过端点路径查看信息
        http://localhost:8080/actuator

     */

}
