package com.jary.daily.grows.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/25 下午9:37
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        //模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//获取许可
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();//访问完，释放，如果屏蔽下面的语句，则在控制台只能打印出5条记录，之后线程一直阻塞
                    }
                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();
    }
}
