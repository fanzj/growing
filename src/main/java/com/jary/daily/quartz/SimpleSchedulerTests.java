package com.jary.daily.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fanzhengjie
 * @create 2018/1/4 下午4:09
 * @description
 */
public class SimpleSchedulerTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSchedulerTests.class);

    private Scheduler createScheduler() throws SchedulerException {// 创建调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }

    private void scheduleJob(Scheduler scheduler){
        JobDetail jobDetail ;
    }

    public static void main(String[] args){
    }

}
