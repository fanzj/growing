package com.jary.daily.grows.thread.lock;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/30 下午4:23
 * synchronized 读互斥
 */
public class ReadTest {


    public static void main(String[] args){
        final ReadTest readTest = new ReadTest();
        new Thread(){
            @Override
            public void run() {
                readTest.get(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                readTest.get(Thread.currentThread());
            }
        }.start();
    }

    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName()+"正在进行读操作");
        }
        System.out.println(thread.getName()+"读操作完毕");
    }
}
