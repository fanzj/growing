package com.jary.daily.grows.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/29 上午8:46
 */
public class Test {

    /**
     * 自定义的一个UncaughtExceptionHandler
     */
    static class ErrHandler implements Thread.UncaughtExceptionHandler {

        /**
         * 这里可以做任何针对异常的处理,比如记录日志等等
         */
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("This is:" + t.getName() + ", Message:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = null;
        Lock lock = new ReentrantLock();


        test4();

    }

    private void viewSourceCode() {
        //通过Executors提供四种线程池
        ExecutorService service1 = Executors.newCachedThreadPool();//1
        ExecutorService service2 = Executors.newFixedThreadPool(3);//2
        ExecutorService service3 = Executors.newScheduledThreadPool(3);//3
        ExecutorService service4 = Executors.newSingleThreadExecutor();//4
    }

    private static void test1() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
        service.shutdown();
    }

    private static void test2() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }

    private static void test3() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds ");
            }
        }, 3, TimeUnit.SECONDS);

       /* ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds"+Thread.currentThread().getName());
            }
        }, 1, 3, TimeUnit.SECONDS);*/
    }

    public static void test4(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


}
