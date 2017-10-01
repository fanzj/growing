package com.jary.daily.grows.thread.consumer;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/30 上午9:45
 */
public class Producer implements Runnable {
    @Override
    public void run() {
        int count = 10;
        while(count>0){
            synchronized (Test.obj){
                System.out.println("A");
                count--;
                Test.obj.notify();

                try {
                    Test.obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
