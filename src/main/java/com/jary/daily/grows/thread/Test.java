package com.jary.daily.grows.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
            System.out.println("This is:"+t.getName()+", Message:"+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service = Executors.newFixedThreadPool(3);
        Thread thread = null;
        Lock lock = new ReentrantLock();

    }
}
