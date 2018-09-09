package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringDemo {

    public static void main( String[] args )
    {
        // 通过ClassPathXmlApplicationContext实例化上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        // 根据id获取Bean的实例
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        // 执行pring方法
        helloSpring.print();
        User user =(User) context.getBean("user");
        user.userInfo();
    }
}
