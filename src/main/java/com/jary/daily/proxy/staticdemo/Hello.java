package com.jary.daily.proxy.staticdemo;

/**
 * @author fanzhengjie
 * @create 2019/11/1 下午5:38
 * @description
 */
public class Hello implements IHello{

    @Override
    public void sayHello(String str) {
        System.out.println("hello " + str);
    }
}
