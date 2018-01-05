package com.jary.daily.quartz;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.impl.JobDetailImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fanzhengjie
 * @create 2018/1/4 下午4:04
 * @description 定义一个Job扫描一个目录中的文件，并显示文件的详细信息
 */
public class ScanDirectoryJob implements Job{

    private static final Logger LOGGER = LoggerFactory.getLogger(ScanDirectoryJob.class);

    /**
     * Job接口中的execute方法体内为一个逻辑事务，所有工作事务在这里完成
     * @param jobExecutionContext 执行上下文环境，包含jobDetail、trigger、jobDataMap、calendar等一系列组合子项
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        String jobName = ((JobDetailImpl)jobDetail).getName();//任务名称

        LOGGER.info(jobName+" fired at "+new Date());//记录任务开始时间

        JobDataMap jobDataMap = jobDetail.getJobDataMap();//任务所配置的数据映射表

        String dirName = jobDataMap.getString("SCAN_DIR");//获取要扫描的目录

        File dir = new File(dirName);
        if(!dir.exists()){
            throw new JobExecutionException("Invalid Dir "+dirName);
        }

        FileFilter filter = new FileExtensionFileFilter(".xml");
        //只统计xml文件
        File[] files = dir.listFiles(filter);

        if (files == null || files.length <= 0) {//目录下没有XML文件
            LOGGER.info("No XML files found in " + dir);

            // Return since there were no files
            return;
        }

        // The number of XML files
        int size = files.length;
        LOGGER.info("The number of XML files: " + size);

        // Iterate through the files found
        for (File file : files) {
            // Log something interesting about each file
            File aFile = file.getAbsoluteFile();
            long fileSize = file.length();
            String msg = aFile + " - Size: " + fileSize;

            LOGGER.info(msg);   //记录下文件的路径和大小
        }


    }
}
