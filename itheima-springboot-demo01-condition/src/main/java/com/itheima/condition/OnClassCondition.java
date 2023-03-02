package com.itheima.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //根据某种条件达到 ：添加了坐标 true 不添加坐标 返回false
            //1.获取当前的redis的类字节码对象
       /* try {
             //2.加载成功则说明存在 redis的依赖 返回true，
            Class.forName("redis.clients.jedis.Jedis");//jedisx
            return true;
        } catch (ClassNotFoundException e) {
            // 如果加载不成功则redis依赖不存在 返回false
            return false;
        }*/



        //1.获取自定义中的注解的方法中value的返回值
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnClass.class.getName());
        String[] values = (String[]) annotationAttributes.get("value");
        //2.获取到全路径 然后进行加载
        try {
            for (String value : values) {
                Class.forName(value);
            }
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }


    }
}
