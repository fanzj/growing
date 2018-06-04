package com.jary.daily.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fanzhengjie
 * @create 2018/4/20 下午1:47
 * @description
 */
public class QuartzJob1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzJob1.class);

    public void work(){
        task1();
    }

    public void task1(){
        LOGGER.warn("QuartzJob1.task1()  每隔5分钟执行一次");
    }


}
