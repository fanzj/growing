package com.jary.daily.grows.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/28 下午1:27
 */
public class Main2 {


    public static void main(String[] args) throws InterruptedException {

        AtomicInteger num = new AtomicInteger(0);

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                num.incrementAndGet();
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                num.incrementAndGet();
            }
        });

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                num.decrementAndGet();
            }
        });

        Thread D = new Thread(new Runnable() {
            @Override
            public void run() {
                num.decrementAndGet();
            }
        });

        A.start();
        B.start();
        C.start();
        D.start();
       /* A.join();
        B.join();
        C.join();
        D.join();*/

        System.out.println(num);

    }
}
