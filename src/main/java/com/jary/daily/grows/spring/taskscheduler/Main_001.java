package com.jary.daily.grows.spring.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/16 下午1:10
 * 计划任务类测试
 */
public class Main_001 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
