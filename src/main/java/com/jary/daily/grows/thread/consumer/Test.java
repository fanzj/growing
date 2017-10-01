package com.jary.daily.grows.thread.consumer;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/30 上午9:34
 */
public class Test {

    public static final Object obj = new Object();

    public static void main(String[] args){
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
    }
}
