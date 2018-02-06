package com.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");     //1、先将活动的Profile设置为prod
        context.register(ProfileConfig.class);                  //2、后置注册bean配置类，不然会报bean未定义的错误
        context.refresh();                                      //3、刷新容器
        //ProfileConfig profileConfig = context.getBean(ProfileConfig.class);
        DemoBean demoBean = context.getBean(DemoBean.class);

        System.out.println("===============");
        System.out.println(demoBean.getContent());
        context.close();
    }
}
