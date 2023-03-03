package com.itheima;

import com.config.MyImportBeanDefinitionRegistrar;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication
//1. 放大 扫描的包路径  可以解决  ！ 不太好 @ComponentScan(basePackages = "com")
//2. 修改demo3的包路径  可以解决  更加不好，更麻烦 不好改


//@EnableUser

//3.使用import注解
//3.1 导入配置类
//@Import(UserConfig.class)
//3.2 直接导入bean 一般不用
//3.3 导入了ImportSelector的实现类 有从外部配置文件中加载的需求才使用这个方式


//@Import(MyImportSelector.class)
//3.4 导入了ImportBeanDefinitionRegistrar的实现类 是需要手动的进行创建一个对象叫gei spring容器需求采用。
@Import(MyImportBeanDefinitionRegistrar.class)
public class Demo2Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo2Application.class, args);
        Object user = context.getBean("abc");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(user);
    }
}

//1.定义两个工程demo2 demo3 demo3中有bean
//2.demo2依赖了demo3
//3.我们希望demo2直接获取加载demo3中的bean
/*
(1) 定义工程：demo2
pom.xml:只加入springbootstarter
(2)在包com.itheima下定义demo2启动类，并加载第三方的依赖中的bean
(3)定义工程demo3
(4) 在demo3工程中定义配置类和POJO
pojo:在com.itheima.pojo下创建
配置类在com.config下创建配置类：
(5)修改demo2工程的pom.xml:加入demo3的依赖
        <dependency>
            <groupId>com.itheima</groupId>
            <artifactId>itheima-springboot-demo03-enable</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
（6）启动测试：发现报错 解决该错误的方式
    1.第一种使用组件扫描 扫描包路径放大    不太好 @ComponentScan(basePackages = "com")
    2.修改demo3的包路径  可以解决  更加不好，更麻烦 不好改
    3.第三种使用import注解进行导入配置类的方式(导入demo3中的类)即可
    {
            //3.使用import注解
            //3.1 导入配置类
            //@Import(UserConfig.class)
            //3.2 直接导入bean 一般不用
            //3.3 导入了ImportSelector的实现类 有从外部配置文件中加载的需求才使用这个方式
            //@Import(MyImportSelector.class)
            //3.4 导入了ImportBeanDefinitionRegistrar的实现类 是需要手动的进行创建一个对象叫gei spring容器需求采用。
    }
*/


/*
实现优化加载第三bean
（1）在demo03中com.config下创建一个自定义注解@EnableUser：
（2）在demo2中Demo2Application使用该注解即可
 */


//ImportSector实现类方式
/*

在demo3工程中定义类  --》MyImportSelector
定义POJO:
在demo2中修改导入：
        @Import(MyImportSelector.class)
        //
        User user = context.getBean(User.class);
        Role role = context.getBean(Role.class);

 */

