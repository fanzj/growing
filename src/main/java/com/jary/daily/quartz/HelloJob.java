package com.jary.daily.quartz;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author fanzhengjie
 * @create 2018/1/5 上午11:16
 * @description
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务执行中 "+new Date());
    }
}
