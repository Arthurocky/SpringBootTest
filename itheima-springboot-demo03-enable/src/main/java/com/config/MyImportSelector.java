package com.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //1.模拟从外部文件properties读取所有的类全路径
        System.out.println("加载了外部的配置文件properties获取到了内容");
        //2.得到了全路径 多个路径（配置的类全路径 比如：com.itheima.Userconfig,com.itheima.RoleConfig）
        //3.返回字符串数组 spring容器会自动的将这些全路径通过反射创建对象 交给spring容器管理
        return new String[]{"com.itheima.pojo.User","com.itheima.pojo.Role"};
    }
}
