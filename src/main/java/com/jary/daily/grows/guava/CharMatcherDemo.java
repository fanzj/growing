package com.jary.daily.grows.guava;

import com.google.common.base.CharMatcher;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/3 上午9:55
 */
public class CharMatcherDemo {

    private static void test() {
        System.out.println(CharMatcher.digit().retainFrom("mahse123sfd"));
        System.out.println(CharMatcher.whitespace().trimAndCollapseFrom("      Mahesh Parashar ", ' '));
        System.out.println(CharMatcher.javaDigit().replaceFrom("jiweqw12343sjfs34", "*"));

        System.out.println(CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom("kjs324sfjJKfa&^&qdjah"));
    }

    public static void main(String[] args) {
        test();
    }

}