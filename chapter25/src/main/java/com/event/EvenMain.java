package com.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类
 */
public class EvenMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("Hello appllcation event");
        context.close();
    }
}
