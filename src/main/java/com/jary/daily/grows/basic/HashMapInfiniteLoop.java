package com.jary.daily.grows.basic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/3 下午3:32
 * HashMap死循环
 */
public class HashMapInfiniteLoop implements Serializable {



    private static Map<Integer,Integer> map = new HashMap<>(2,0.75f);

    public static void main(String[] args){
        map.put(5,55);

        new Thread("Thread1"){
            @Override
            public void run() {
                map.put(7,77);
                System.out.println(map);
            }
        }.start();

        new Thread("Thread2"){
            @Override
            public void run() {
                map.put(3,33);
                System.out.println(map);
            }
        }.start();
    }
}
