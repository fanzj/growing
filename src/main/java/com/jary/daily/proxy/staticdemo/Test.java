package com.jary.daily.proxy.staticdemo;

/**
 * @author fanzhengjie
 * @create 2019/11/1 下午5:40
 * @description 静态代理
 */
public class Test {

    public static void main(String[] args) {
        IHello hello = new ProxyHello(new Hello());
        hello.sayHello("jack");

    }

}
