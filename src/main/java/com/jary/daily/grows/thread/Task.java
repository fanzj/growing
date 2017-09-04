package com.jary.daily.grows.thread;

import com.jary.daily.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/4 上午10:04
 */
public class Task {

    /**
     * 定时任务
     * 普通thread
     * 这是最常见的，创建一个thread，然后让它在while循环里一直运行着，
     * 通过sleep方法来达到定时任务的效果。
     */
    public static void task1(){
        //run in a second
        final long timeInterval = 1000;
        final int[] stop = {0};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (stop[0] < 30){
                    //code for task to run
                    System.out.println("task run "+stop[0]);
                    //end

                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stop[0]++;
                }
            }
        };

        new Thread(runnable).start();
    }

    public static void task2(){
        final int[] i = {0};
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task run "+(i[0]++));
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        // schedules the task to be run in an interval

        //timer.scheduleAtFixedRate(task, delay, intevalPeriod);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = format.parse("2017-09-04 11:17:00" );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(task, date,intevalPeriod);
    }

    public static void task3(){
        final int[] i = {0};
        Runnable runnable = new Runnable() {
            public void run() {
                // task to run goes here
                System.out.println("task run "+(i[0]++));
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args){
        task2();
    }
}
