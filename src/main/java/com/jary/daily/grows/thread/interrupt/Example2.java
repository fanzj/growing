package com.jary.daily.grows.thread.interrupt;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/15 上午10:25
 * 使用中断信号量中断非阻塞状态的线程
 */
public class Example2 extends Thread {


    volatile boolean stop = false;//线程中断信号量

    @Override
    public void run() {
        while(!stop){//每秒检测一下中断信号量
            System.out.println("Thread is running...");
            long time = System.currentTimeMillis();

            while(System.currentTimeMillis() - time < 1000){

            }
        }
        System.out.println("Thread exiting under request...");
    }

    public static void main(String[] args) throws InterruptedException {
        Example2 thread = new Example2();
        System.out.println("Satrting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        //发出中断请求
        thread.stop = true;
        Thread.sleep(3000);
        System.out.println("Stop application...");
    }
}
