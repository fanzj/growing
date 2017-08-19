package com.jary.daily.test;

import java.util.Random;

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
    }
}
