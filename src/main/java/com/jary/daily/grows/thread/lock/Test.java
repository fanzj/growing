package com.jary.daily.grows.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/30 下午4:03
 */
public class Test {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Test test = new Test();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    /**
     * lock.lockInterruptibly() 可以成功被中断
     * synchronzied则不可以
     * @param thread
     * @throws InterruptedException
     */
    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            System.out.println(thread.getName()+"得到了锁");
            long startTime = System.currentTimeMillis();
            for(;;){
                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE){
                    break;
                }
                //模拟一个耗时的插入数据操作
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"执行finally");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }
    }
}

class MyThread extends Thread {

    private Test test;

    public MyThread(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
