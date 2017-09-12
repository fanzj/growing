package com.jary.daily.grows.thread;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/12 下午7:49
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 使用synchronized、wait、notify实现带阻塞的线程安全队列
 *
 * @ClassName: DemoThread19
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51
 */
class MQueue {

    private volatile List<String> list = new ArrayList<String>();

    private int maxSize;

    private int curSize;

    private Object lock = new Object();

    public MQueue(int maxSize){
        this.maxSize=maxSize;
        this.curSize = 0;
        System.out.println("线程"+Thread.currentThread().getName()+"已初始化长度为"+this.maxSize+"的队列");
    }

    public void put(String element){
        synchronized (lock) {
            while(this.curSize==this.maxSize){
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"当前队列已满put等待..."+", curSize = "+curSize+", maxSize = "+maxSize);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.list.add(element);
            this.curSize = list.size();
            System.out.println("线程"+Thread.currentThread().getName()+"向队列中加入元素:"+element+", curSize = "+curSize+", maxSize = "+maxSize);
            lock.notifyAll(); //通知可以取数据
        }
    }

    public String take(){
        synchronized (lock) {
            while(this.curSize==0){
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"队列为空take等待..."+", curSize = "+curSize+", maxSize = "+maxSize);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String result = list.get(0);
            list.remove(0);
            this.curSize = list.size();
            System.out.println("线程"+Thread.currentThread().getName()+"获取数据:"+result+", curSize = "+curSize+", maxSize = "+maxSize);
            lock.notifyAll(); //通知可以加入数据
            return result;
        }
    }
}

