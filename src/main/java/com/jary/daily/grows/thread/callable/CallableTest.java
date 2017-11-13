package com.jary.daily.grows.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/13 下午3:12
 * Callable执行测试类
 */
public class CallableTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CallableDemo callableDemo = new CallableDemo();
        //法1
       // Future<Integer> result = executorService.submit(callableDemo);

        //法2
        FutureTask<Integer> result = new FutureTask<Integer>(callableDemo);
        executorService.submit(result);

        executorService.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("主线程执行其他任务");
            if(result.get()!=null){
                System.out.println("result.get() -> "+result.get());
            }else{
                System.out.println("result.get()未获取到结果");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完成");
    }

}
