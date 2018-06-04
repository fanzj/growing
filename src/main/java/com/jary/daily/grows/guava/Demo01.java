package com.jary.daily.grows.guava;

import com.sun.tools.javac.util.Pair;

/**
 * @author fanzhengjie
 * @create 2018/5/3 下午4:21
 * @description
 */
public class Demo01 {

    public static void main(String[] args){
        Pair pair = Pair.of(123,"hello");
        System.out.println(pair.fst);
        System.out.println(pair.snd);
    }

}
