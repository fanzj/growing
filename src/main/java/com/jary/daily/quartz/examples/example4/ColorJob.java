package com.jary.daily.quartz.examples.example4;

import java.util.Date;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fanzhengjie
 * @create 2018/1/5 下午2:55
 * @description
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ColorJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorJob.class);
    // parameter names specific to this job
    public static final String FAVORITE_COLOR = "favorite color";
    public static final String EXECUTION_COUNT = "count";

    // Since Quartz will re-instantiate a class every time it
    // gets executed, members non-static member variables can
    // not be used to maintain state!
    private int _counter = 1;

    public ColorJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();

        JobDataMap data = jobExecutionContext.getJobDetail().getJobDataMap();
        String favoriteColor = data.getString(FAVORITE_COLOR);
        int count = data.getInt(EXECUTION_COUNT);
        LOGGER.info("ColorJob: " + jobKey + " executing at " + new Date() + "\n" +
            "  favorite color is " + favoriteColor + "\n" +
            "  execution count (from job map) is " + count + "\n" +
            "  execution count (from job member variable) is " + _counter);

        // increment the count and store it back into the
        // job map so that job state can be properly maintained
        count++;
        data.put(EXECUTION_COUNT, count);

        // Increment the local member variable
        // This serves no real purpose since job state can not
        // be maintained via member variables!
        _counter++;
    }
}
