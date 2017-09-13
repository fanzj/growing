package com.jary.daily.test;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/13 上午11:11
 */
public class NumTest {

    @Test
    public void IntegerTest() {
        System.out.println("Integer测试");
        Integer i1 = 40;//换成400则i1=i2?false，因为超出常量池范围
        Integer i2 = 40;
        Integer i3 = 0;

        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2?" + (i1 == i2));
        System.out.println("i1=i2+i3?" + (i1 == i2 + i3));
        System.out.println("i4=i5?" + (i4 == i5));
        System.out.println("i4=i5+i6?" + (i4 == i5 + i6));

        Integer a = new Integer(7);
        System.out.println(Integer.toString(a,6));
    }
}
