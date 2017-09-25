package com.jary.daily.grows.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/25 上午10:03
 * 线程计数器
 */
public class TestCyclicBarrier {

    private static final int THREAD_NUM = 5;

    public static class WorkerThread implements Runnable{

        CyclicBarrier cyclicBarrier;

        public WorkerThread(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try{
                System.out.println("Worker's waiting");
                //线程在这里等待，直到所有线程都到barrier
                cyclicBarrier.await();
                System.out.println("ID:"+Thread.currentThread().getId()+" Working");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        CyclicBarrier cb = new CyclicBarrier(THREAD_NUM, new Runnable() {
            //当所有线程到达barrier时执行
            @Override
            public void run() {
                System.out.println("Inside Barrier");
            }
        });

        for(int i=0;i<THREAD_NUM;i++){
            new Thread(new WorkerThread(cb)).start();
        }
    }
}
