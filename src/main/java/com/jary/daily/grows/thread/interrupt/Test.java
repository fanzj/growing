package com.jary.daily.grows.thread.interrupt;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/11 下午5:52
 * 结束未使用阻塞函数的线程
 */
public class Test {

    public static void main(String[] args){
        InnerClass innerClass = new InnerClass();
        Thread thread = new Thread(innerClass);
        thread.start();
        long i = System.currentTimeMillis();
        while(System.currentTimeMillis() - i < 10*1000){
            thread.isAlive();
        }
        thread.interrupt();
    }

    static class InnerClass implements Runnable{

        @Override
        public void run() {
            System.err.println("start work");
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("doing work");
            }
            System.err.println("done work");
        }
    }

}
