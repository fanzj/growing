package com.jary.daily.grows.spring.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/16 下午1:01
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private int num = 0;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        num ++;
        System.out.println(num+"每隔五秒执行一次 "+dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 20 13 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间 "+dateFormat.format(new Date())+"执行");
    }

}
