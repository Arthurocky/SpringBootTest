package com.itheima.redis.config;


import com.itheima.redis.pojo.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

//自动配置类
@Configuration
@EnableConfigurationProperties(RedisProperties.class)//作用 就是讲这个类交给spring容器管理
@ConditionalOnClass(Jedis.class)//标识 当前classpath下如果有jedis类的时候才会执行配置类的配置
public class RedisAutoConfiguration {

    @Autowired
    private RedisProperties redisProperties;

    //创建一个Jedis对象 放到容器中 别人直接注入
    @Bean
    //这个方法要执行的前提是 那个初级不配置，我就帮他配置，如果他配置了就不配置了
    @ConditionalOnMissingBean(Jedis.class)//容器中没有jedis这个bean
    public Jedis jedis(){
        System.out.println(redisProperties.getHost()+">>>"+redisProperties.getPort());
        return new Jedis(redisProperties.getHost(),redisProperties.getPort());
    }
}
