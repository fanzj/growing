package com.jary.daily.grows.jvm;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/23 上午9:52
 */
public class SClass extends SSClass {

    static {
        System.out.println("SClass init.");
    }

    public static int value = 123;

    public SClass(){
        System.out.println("SClass construct.");
    }
}
