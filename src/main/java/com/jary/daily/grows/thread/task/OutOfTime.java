package com.jary.daily.grows.thread.task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/14 上午11:21
 */
public class OutOfTime {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);
        Thread.sleep(1000);
        timer.schedule(new ThrowTask(),1);
        Thread.sleep(5000);
    }

    static class ThrowTask extends TimerTask{

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }



}
