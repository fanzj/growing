package com.jary.daily.grows.thread.callable;

import java.util.concurrent.Callable;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/13 下午3:10
 * Callable接口实例
 */
public class CallableDemo implements Callable<Integer>{

    private int sum;

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable子线程开始计算");
        Thread.sleep(2000);

        for(int i=0;i<5000;i++){
            sum += i;
        }
        System.out.println("Callable子线程计算结束");
        return sum;
    }
}
