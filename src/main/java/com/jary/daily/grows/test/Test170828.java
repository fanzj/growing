package com.jary.daily.grows.test;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 下午3:21
 */
public class Test170828 {


    public static void main(String[] args) {
       // int k = 1 ^ (1 << 31 >> 31);
       // System.out.println(k);

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);



    }

    public static void print(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}
