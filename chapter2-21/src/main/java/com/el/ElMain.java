package com.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.el");
        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outputResource();
        context.close();

    }
}
