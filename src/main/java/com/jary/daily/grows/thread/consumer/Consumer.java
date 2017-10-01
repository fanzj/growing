package com.jary.daily.grows.thread.consumer;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/30 上午9:33
 * 消费者
 */
public class Consumer implements Runnable{
    @Override
    public synchronized void run() {
        int count = 10;
        while(count>0){
            synchronized (Test.obj){
                System.out.println("B");
                count--;
                Test.obj.notify();//主动释放du对象锁
                try {
                    Test.obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
