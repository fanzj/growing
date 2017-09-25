package com.jary.daily.grows.java8;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/22 下午9:15
 */
public interface TestInterface {

    int test();

    default void print(){
        System.out.println("Java8中接口中的非抽象方法实现");
    }
}
