package com.jary.daily.grows.algorithms.design.observer;

/**
 * @author fanzhengjie
 * @create 2018/4/4 上午11:08
 * @description
 */
public class Test {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("crj");

        server.registerObserver(userZhang);
        server.setInfomation("b","c");

        System.out.println("----------------------------------------------");
        Observer userLi = new User("rp");
        server.removeObserver(userZhang);
        server.registerObserver(userLi);
        server.setInfomation("e","f");

    }
}
