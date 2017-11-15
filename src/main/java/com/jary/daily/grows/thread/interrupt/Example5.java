package com.jary.daily.grows.thread.interrupt;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/15 下午2:25
 */
public class Example5 {


    static void deadLock(Object lock1, Object lock2) {
        try {
            synchronized (lock1) {
                Thread.sleep(10);//不会在这里死掉
                synchronized (lock2) {//会锁在这里，虽然阻塞了，但是不会抛异常
                    System.out.println(Thread.currentThread());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                deadLock(lock1, lock2);
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                deadLock(lock2, lock1);
            }
        };

        System.out.println("Starting thread...");
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread...");
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }
}
