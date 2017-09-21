package com.jary.daily.grows.spring.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/16 下午1:09
 */
@Configuration
@ComponentScan("com.jary.daily.spring")
@EnableScheduling
public class TaskSchedulerConfig {
}
