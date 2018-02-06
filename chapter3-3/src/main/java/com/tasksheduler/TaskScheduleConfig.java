package com.tasksheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 配置类
 */
@Configuration
@ComponentScan("com.tasksheduler")
//1、通过@EnableScheduling主键开启对计划任务的支持
@EnableScheduling
public class TaskScheduleConfig {

}
