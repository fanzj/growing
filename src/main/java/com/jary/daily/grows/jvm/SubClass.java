package com.jary.daily.grows.jvm;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/23 上午9:53
 */
public class SubClass extends SClass {

    static {
        System.out.println("SubClass init.");
    }

    static int a;

    public SubClass() {
        System.out.println("SubClass construct.");
    }
}
