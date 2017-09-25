package com.jary.daily.grows.jvm;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/23 上午9:54
 */
public class Test {

    public static void main(String[] args) {
        //System.out.println(SubClass.value);

        //1.通过数组定义来引用类，不会触发此类的初始化
        // SClass[] sca = new SClass[10];
        // SClass sClass = new SClass();

        //2. 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
        System.out.println(ConstClass.a);
    }
}
