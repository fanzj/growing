package com.jary.daily.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fanzhengjie on 2017/6/5.
 */
public class DateUtils {

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String formatNow(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date());
    }

    public static Date formatDate2(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String strDate = formatter.format(date);
        Date res = null;
        try {
            res = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Date parseDate(String time, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 在当前时间上增加x天
     *
     * @param x 为正表示向后，为负表示向前
     */
    public static Date addXDay(Date date, int x) {
        Date res = (Date) date.clone();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(res);
        calendar.add(Calendar.DATE, x);
        res.setTime(calendar.getTime().getTime());
        return res;
    }

    /**
     * 获取date的第二天
     */
    public static Date getNextDay(Date date) {
        Date res = (Date) date.clone();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(res);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        res.setTime(calendar.getTime().getTime());
        return res;
    }

    /**
     * 设置时间为当月第一天
     */
    public static Date startMonth(Date date) {
        Date res = (Date) date.clone();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(res);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        res.setTime(calendar.getTime().getTime());
        return res;
    }

    /**
     * 设置时间为当月最后一天
     */
    public static Date endMonth(Date date) {
        Date res = (Date) date.clone();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(res);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        res.setTime(calendar.getTime().getTime());
        return res;
    }

    /**
     * 设置时间为下月第一天0点
     */
    public static Date getNextMonthOfFirstDay(Date date) {
        Date res = startMonth(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(res);
        calendar.add(Calendar.MONTH, 1);
        res.setTime(calendar.getTime().getTime());
        return res;
    }

    ///////////////

    /**
     * 获得昨天结束时间
     */
    public static Date yestodayEndTime() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    public static void main(String[] args){
        System.out.println(yestodayEndTime());
    }


}
