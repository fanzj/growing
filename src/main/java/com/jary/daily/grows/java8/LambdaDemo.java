package com.jary.daily.grows.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/7 下午5:16
 */
public class LambdaDemo {

    public static void main(String[] args){
        /*Arrays.asList("a","b","d").forEach(e -> System.out.println(e));
        Arrays.asList("a","b","d").forEach((String e) -> System.out.println(e));
        Arrays.asList("a","b","d").forEach(e -> {
            System.out.println(e);
            System.out.println(e);
        });*/
        /*List<String> list =  Arrays.asList("d","b","a","c");
        list.sort((e1,e2) -> e1.compareTo(e2));
        System.out.println(list);*/

        List<String> list =  Arrays.asList("d","b","a","c");
        list.sort((e1,e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
        System.out.println(list);
    }

}
