package com.jary.daily.grows.thread.interrupt;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/15 上午10:34
 * 使用thread.interrupt()中断非阻塞状态线程
 */
public class Example3 extends Thread{


    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Thread is running...");
            long time = System.currentTimeMillis();

            //使用while循环模拟sleep
            while(System.currentTimeMillis() - time < 1000){

            }
        }
        System.out.println("Thread exiting under request...");
    }

    public static void main(String[] args) throws InterruptedException {
        Example3 thread = new Example3();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        //发出中断请求
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }
}
