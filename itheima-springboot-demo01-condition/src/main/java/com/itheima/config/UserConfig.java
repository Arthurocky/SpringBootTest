package com.itheima.config;

import com.itheima.condition.ConditionalOnClass;
import com.itheima.condition.OnClassCondition;
import com.itheima.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration//注解标记该类是一个配置类
public class UserConfig {


    //这个方法 根据我们添加坐标还是不添加坐标的条件去执行 条件注解

    @Bean
    @Conditional(OnClassCondition.class)
    //这个注解标识 当达到了某种条件【通过一个类的方法的返回值来实现的，true执行，false不执行】他才会执行这个方法,放入spring容器中。

    //自定义注解
    @ConditionalOnClass(value={"redis.clients.jedis.Jedis"})
    public User user(){
        return new User();
    }
}
