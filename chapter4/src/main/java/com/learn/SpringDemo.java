package com.learn;

import com.learn.controller.UserController;
import com.learn.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IOC 基于注解的开发
 *
 */
public class SpringDemo
{
    public static void main( String[] args )
    {
//        xmlIOCDemo();
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       UserController userController = (UserController) context.getBean("userController");
       User user = userController.getUserById(2);

       System.out.println(user);


    }

    /**
     *  xml 配置方式
     */
    private static void xmlIOCDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = (UserController) context.getBean("userController");
        User user = userController.getUserById(3);
        System.out.println(user);
    }
}
