package com.jary.daily.grows.thread.exception;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/29 下午12:02
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(3 / 2);
        System.out.println(3 / 0);
        System.out.println(3 / 1);
    }
}
