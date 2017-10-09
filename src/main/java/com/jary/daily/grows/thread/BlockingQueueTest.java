package com.jary.daily.grows.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/9 上午11:17
 */
public class BlockingQueueTest {

    public static class Producer implements Runnable{

        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;
        private Random random;

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.flag = false;
            this.random = new Random();
        }

        @Override
        public void run() {
            while(!flag){
                int info = random.nextInt(100);
                try {
                    blockingQueue.put(info);
                    System.out.println(Thread.currentThread().getName()+" produce "+info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown(){
            flag = true;
        }
    }

    public static class Consumer implements Runnable{

        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }


        @Override
        public void run() {
            while(!flag){
                int info;
                try {
                    info = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+" consumer "+info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown(){
            flag = true;
        }
    }

    public static void main(String[] args){
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        //创建5个生产者和5个消费者
        for(int i=0;i<10;i++){
            if(i<5){
                new Thread(producer,"producer"+i).start();
            }else{
                new Thread(consumer,"consumer"+i).start();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.shutdown();
        consumer.shutdown();
    }
}
