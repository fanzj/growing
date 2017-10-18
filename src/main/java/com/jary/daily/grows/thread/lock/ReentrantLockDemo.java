package com.jary.daily.grows.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/14 下午6:55
 */
public class ReentrantLockDemo implements Runnable{

    ReentrantLock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName());
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args){
        ReentrantLockDemo lockDemo = new ReentrantLockDemo();
        new Thread(lockDemo).start();
        new Thread(lockDemo).start();
        new Thread(lockDemo).start();
    }
}
