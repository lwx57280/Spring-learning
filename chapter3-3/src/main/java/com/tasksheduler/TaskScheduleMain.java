package com.tasksheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskScheduleMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskScheduleConfig.class);

    }
}
