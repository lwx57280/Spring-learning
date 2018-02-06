package com.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AwareMain {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }
}
