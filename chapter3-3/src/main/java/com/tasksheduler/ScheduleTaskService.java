package com.tasksheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计划任务执行类
 */
@Service
public class ScheduleTaskService {
    private static final SimpleDateFormat DATE_FORMAT= new SimpleDateFormat("HH:mm:ss");

    /**
     * 1、通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行。
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次:"+DATE_FORMAT.format(new Date()));
    }

    /**
     * 2、使用cron属性可按照指定时间执行，cron是UNIX和类UNIX(Linux)系统下的定时任务
     */
    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecutor(){
        System.out.println("指定时间内:"+DATE_FORMAT.format(new Date())+"执行");
    }
}
