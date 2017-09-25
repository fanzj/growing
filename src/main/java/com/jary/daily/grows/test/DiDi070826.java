package com.jary.daily.grows.test;

import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/26 下午12:17
 */
public class DiDi070826 {




    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        for(int i=0;i<10;i++){
            final int j = i;
            executor.execute(new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                        System.out.print(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }


}
