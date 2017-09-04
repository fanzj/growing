package com.jary.daily.grows.thread;

import java.util.*;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/4 上午11:17
 * 吃饭定时
 */
public class EatTimerTask extends TimerTask{

    //吃饭时间
    private static List<Integer> eatTimes;

    static {
        initEatTimes();
    }

    public static void initEatTimes(){
        eatTimes = new ArrayList<>();
        eatTimes.add(8);
        eatTimes.add(12);
        eatTimes.add(18);
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("检查是否到了吃饭的点");
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(eatTimes.contains(hour)){
            System.out.println("吃饭");
        }
    }

    public static void main(String[] args){
        TimerTask task = new EatTimerTask();
        Calendar calendar = Calendar.getInstance();

        Date firstTIme = calendar.getTime();
        //long period = 1000 * 60 * 60;//间隔1小时
        long period = 1000 * 60;//1分钟

        Timer timer = new Timer();
        timer.schedule(task,firstTIme,period);
    }
}
