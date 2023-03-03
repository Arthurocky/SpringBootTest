package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestApplication.class, args);
        //这个方法 是手动获取bean 相当于注入
        Object jedis = applicationContext.getBean("jedis");
        System.out.println(jedis);
    }

    //我：初级 我自己来创建bean  我也不知道你到底有没有创建（不想知道）
    /*@Bean
    public Jedis jedis(){
        return new Jedis("192.168.233.111",999);
    }*/



/*
需求说明
当加入redis客户端的坐标的时候，自动配置jedis的bean 加载到spring容器中。

实现步骤
我们可以参考springboot整合mybatis的依赖进行配置实现。为了简单起见我们只定义一个工程即可。

1.创建工程  -->itheima-test-starter-redis-springboot
2.添加依赖
       <!--redis的依赖jedis-->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>3.2.0</version>
        </dependency>
3.创建自动配置类和POJO(itheima-test-starter-redis-springboot)
在resources下创建META-INF/spring.factories文件并定义内容如下：

4.创建工程 itheima-test-starter 用于测试使用 添加依赖
    <!--加入itheima的redis的起步依赖-->
        <dependency>
            <groupId>com.itheima</groupId>
            <artifactId>itheima-redis-springboot-starter</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
 */


}
