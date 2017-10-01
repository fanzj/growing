package com.jary.daily.grows.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/30 下午9:20
 * ReentrantReadWriteLock保证读读
 */
public class ReadTest2 {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args){
        final ReadTest2 readTest2 = new ReadTest2();

        new Thread(){
            @Override
            public void run() {
                readTest2.get(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                readTest2.get(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread){
        lock.readLock().lock();
        try{
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis() - start <= 1){
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        }finally {
            lock.readLock().unlock();
        }
    }
}
