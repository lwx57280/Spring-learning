package com.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Profile配置
 */
public class ProfileConfig {

    @Bean
    @Profile("dev")         //1、Profile为dev时实例化devDemoBean
    public DemoBean devDemoBean(){

        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod")        //2、Profile为prod时实例化prodDemoBean
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }
}
