package com.jary.daily.grows.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/22 下午9:18
 */
public class Test {

    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Alice");
        names.add("Tom");
        names.add("Jack");
        Collections.sort(names,(String a,String b)->{
            return a.compareTo(b);
        });

        for (String name:names
             ) {
            System.out.println("name = "+name);
        }
    }
}
