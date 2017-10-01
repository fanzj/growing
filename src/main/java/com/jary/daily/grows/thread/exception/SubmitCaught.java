package com.jary.daily.grows.thread.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/29 下午12:31
 */
public class SubmitCaught {

    public static void main(String[] args) {
       /* ExecutorService service = Executors.newCachedThreadPool();
        //service.submit(new Task());
        service.submit(new ThreadPoolTask());
        service.shutdown();*/

        ExecutorService service = Executors.newCachedThreadPool();
        Future<?> future = service.submit(new Task());
        service.shutdown();
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("==Exception: " + e.getMessage());
        }
    }
}
