package com.jary.daily.grows.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/8 下午7:14
 * 线程池测试例子
 */
public class Test {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable{

    private int taskNum;

    public MyTask(int taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+ taskNum+"执行完毕");
    }
}
