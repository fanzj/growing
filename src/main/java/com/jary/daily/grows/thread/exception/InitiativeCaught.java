package com.jary.daily.grows.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/29 上午11:52
 */
public class InitiativeCaught {

    public void threadDeal(Runnable r,Throwable t){
        System.out.println("==Exception: "+t.getMessage());
    }

    class InitialtiveThread implements Runnable{

        @Override
        public void run() {
            Throwable thrown = null;
            try{
                System.out.println(3/2);
                System.out.println(3/0);
                System.out.println(3/1);
            }catch (Throwable e){
                thrown = e;
            } finally {
                threadDeal(this, thrown);
            }
        }
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new InitiativeCaught().new InitialtiveThread());
        service.shutdown();
    }
}
