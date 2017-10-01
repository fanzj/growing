package com.jary.daily.grows.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/29 下午12:29
 */
public class ExecuteCaught {

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ThreadPoolTask());
        exec.shutdown();
    }
}
