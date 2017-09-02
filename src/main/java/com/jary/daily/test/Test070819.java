package com.jary.daily.test;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 下午1:35
 */
public class Test070819 {

    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(100);
        System.out.println(r % 10);
        System.out.println(r & (10 - 1));
        ConcurrentMap<String,Integer> map = new ConcurrentHashMap<>();
        System.out.println("===================");
        System.out.println(Runtime.getRuntime().maxMemory());//最大可用内存 -Xmx
        System.out.println(Runtime.getRuntime().freeMemory());//当前JVM空闲内存
        System.out.println(Runtime.getRuntime().totalMemory());//当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
    }
}
