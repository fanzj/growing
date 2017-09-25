package com.jary.daily.grows.thread.countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/25 下午4:14
 */
public class CountDownLatchDemo {

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);//2个工人的协作
        Worker worker1 = new Worker("张三", 5000, latch);
        Worker worker2 = new Worker("李四", 8000, latch);
        worker1.start();
        worker2.start();
        latch.await();//等待所有工人完成工作
        System.out.println("All work done at " + sdf.format(new Date()));

    }

    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Worker " + workerName + " do work begin at " + sdf.format(new Date()));
            doWork();//耗时操作 模拟工作
            System.out.println("Worker " + workerName + " do work complete at " + sdf.format(new Date()));
            latch.countDown();//工人完成工作，计数器减1
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
