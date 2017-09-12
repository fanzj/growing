package com.jary.daily.grows.thread;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/12 下午7:51
 */
public class DemoThread20 {

    public static void main(String[] args) {
        final MQueue q = new MQueue(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                q.put("1");
                q.put("2");
                q.put("3");
                q.put("4");
                q.put("5");
                q.put("6");
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                q.put("11");
                q.put("21");
                q.put("31");
                q.put("41");
                q.put("51");
                q.put("61");
            }
        },"t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                q.take();
                q.take();
                q.take();
                q.take();
                q.take();
            }
        },"t3").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                q.take();
                q.take();
                q.take();
                q.take();
                q.take();
            }
        },"t4").start();
    }
}
