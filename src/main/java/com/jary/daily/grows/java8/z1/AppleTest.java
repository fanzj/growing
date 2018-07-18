package com.jary.daily.grows.java8.z1;

import java.util.Comparator;
import java.util.List;

/**
 * @author fanzhengjie
 * @create 2018/7/5 上午10:42
 * @description
 */
public class AppleTest {


    public static void main(String[] args){
        List<Apple> list = Apple.generateAppleList();
        System.out.println("排序前：");
        System.out.println(list);
        System.out.println("排序后：");
        list.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(list);
    }

}
