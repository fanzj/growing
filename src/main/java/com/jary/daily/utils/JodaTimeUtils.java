package com.jary.daily.utils;

import java.util.Calendar;
import org.joda.time.DateTime;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/8 上午10:53
 */
public class JodaTimeUtils {

    /**
     * 创建任意时间对象
     */
    private static void test1(){
        //jdk
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,Calendar.DECEMBER,8,10,56,30);
        System.out.println(calendar.getTime().toString());

        //joda-time
        DateTime dateTime = new DateTime(2017,12,8,10,56,31);
        dateTime = dateTime.plusDays(1);
        System.out.println(dateTime.toString());
    }

    public static void main(String[] args){
        test1();
    }

}
