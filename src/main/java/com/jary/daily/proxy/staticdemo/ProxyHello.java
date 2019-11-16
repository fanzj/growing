package com.jary.daily.proxy.staticdemo;

/**
 * @author fanzhengjie
 * @create 2019/11/1 下午5:39
 * @description 代理类
 */
public class ProxyHello implements IHello{

    private IHello hello;

    public ProxyHello(IHello hello) {
        super();
        this.hello = hello;
    }

    @Override
    public void sayHello(String str) {
        System.out.println("sayHello start");
        hello.sayHello(str);
        System.out.println("sayHello end");

    }
}
