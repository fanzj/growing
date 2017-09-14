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
        System.out.println(Integer.toString(a, 6));
    }

    public static void main(String[] args) {
        int i1 = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        //Integer会自动拆箱为int，所以为true
        System.out.println(i1 == i2);//true
        System.out.println(i1 == i3);//true
        System.out.println(i2 == i3);//false  堆对象和栈对象，对象之间比较，而自动拆箱后对象都转换为int比较值

        System.out.println("----------------------");
        Integer i4 = 127;//java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i5 = 127;
        System.out.println(i4 == i5);//true

        Integer i6 = new Integer(126);
        Integer i7 = new Integer(126);
        System.out.println(i6 == i7);//false  堆中两个不同对象

        System.out.println("----------------------");
        Integer i8 = new Integer(127);
        System.out.println(i4 == i8); //false  堆对象和栈对象，对象之间比较，
        Integer i9 = new Integer(128);
        Integer i10 = new Integer(128);
        System.out.println(i9 == i10);  //false 堆中两个不同对象
    }

    public void test(){
        int high = 127;
        int low = -128;
        Integer[] cache = new Integer[(high - low) + 1];//缓冲池
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);
    }
}
