package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class MySpringBootApplication {
    public static void main(String[] args) {
        //容器上下文--》spring容器本身
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MySpringBootApplication.class, args);

        //1.
        //添加依赖成功————》说明已经有了RedisTemplete对象 从容器中获取这个对象
        /*Object redisTemplate = applicationContext.getBean("redisTemplate");*/
        //System.out.println(redisTemplate);
        //注释依赖则报错：

        //2.在spring容器中有一个user的bean对象，如果导入了redisclient的坐标则加载该bean，如果没有导入则不加载该bean.
        //步骤如下：
        //1.定义一个接口condition的实现类
        //2.实现方法 判断是否有字节码对象，有则返回true 没有则返回false
        //3.定义一个User的pojo
        //4.定义一个配置类用于创建user对象交给spring容器管理
        //5.修改加入注解@conditional(value=Condition)
        //6.测试打印
        Object user = applicationContext.getBean("user");
        System.out.println(user);


        //3.我们希望这个类注解可以进行动态的加载某一个类的全路径，不能写死为redis.将来可以进行重用。
        // 1.自定义注解   ConditionalOnClass
        // 2.配置类使用注解  UserConfig
        // 3.条件实现类中修改方法实现  matches

        //ConditionalOnBean   当spring容器中有某一个bean时使用
        //ConditionalOnClass  当判断当前类路径下有某一个类时使用
        //ConditionalOnMissingBean 当spring容器中没有某一个bean时才使用
        //ConditionalOnMissingClass 当当前类路径下没有某一个类的时候才使用
        //ConditionalOnProperty 当配置文件中有某一个key value的时候才使用


        // 切换内置的web容器
        // 我们知道在springboot启动的时候如果我们使用web起步依赖，那么我们默认就加载了tomcat的类嵌入了tomcat了，不需要额外再找tomcat。
        //入pom.xml中spring-boot-starter-web起步依赖
        //web容器有4种类型：
        //+ tomcat容器
        //+ jetty
        //+ netty
        //+ undertow
        //默认spring-boot-starter-web加入的是tomcat ,所以根据上图配置，会配置tomcat作为web容器
        //尝试修改web容器：
        //<dependency>
        //    <groupId>org.springframework.boot</groupId>
        //    <artifactId>spring-boot-starter-web</artifactId>
        //    <exclusions>
        //        <exclusion>
        //            <artifactId>spring-boot-starter-tomcat</artifactId>
        //            <groupId>org.springframework.boot</groupId>
        //        </exclusion>
        //    </exclusions>
        //</dependency>
        //
        //<dependency>
        //    <groupId>org.springframework.boot</groupId>
        //    <artifactId>spring-boot-starter-jetty</artifactId>
        //</dependency>

    }
}
