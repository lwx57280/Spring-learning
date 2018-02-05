package javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class javaMain {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.SayHello("java config"));
        context.close();
    }
}

