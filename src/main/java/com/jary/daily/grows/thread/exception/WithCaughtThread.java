package com.jary.daily.grows.thread.exception;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/29 下午12:03
 */
public class WithCaughtThread {

    public static void main(String[] args){
        Thread task = new Thread(new Task());
        task.setUncaughtExceptionHandler(new ExceptionHandler());
        task.start();
    }

}

class ExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("==Exception: "+e.getMessage());
    }
}