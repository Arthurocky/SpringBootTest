package com.itheima.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {

    }
    @Override
    public void starting() {
        System.out.println("====starting 启动中准备工作===");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("====environmentPrepared 环境准备好了但是容器还没创建===");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("====contextPrepared 容器已经创建了但是资源还没加载===");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("====contextLoaded 容器的资源加载了但是还没刷新===");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("====started 容器已经刷新成功启动了===");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("====running 启动成功了===");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("====failed 启动失败了===");
    }
}
