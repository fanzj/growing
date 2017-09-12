package com.jary.daily.test;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 下午3:21
 */
public class Test170828 {


    public static void main(String[] args) {
        int k = 1 ^ (1 << 31 >> 31);
        System.out.println(k);
    }

    public static void print(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}
