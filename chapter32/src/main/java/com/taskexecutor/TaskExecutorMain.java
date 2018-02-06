package com.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskExecutorMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService taskService = context.getBean(AsyncTaskService.class);
        for (int i=0;i<10;i++){
            taskService.executeAsyncTask(i);
            taskService.executeAsyncTaskPlush(i);

        }
        context.close();
    }
}
