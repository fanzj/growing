package com.jary.daily.grows.jvm;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/23 上午10:49
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init.");
    }

    public static final int a = 123;//注意，定义了final常量

}
