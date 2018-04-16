package com.jary.daily.grows.algorithms.design.observer;

/**
 * @author fanzhengjie
 * @create 2018/4/4 上午11:08
 * @description
 */
public class Test {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("出入金");

        server.registerObserver(userZhang);
        server.setInfomation("com.enniu.service.cashflow.warn","monitors");

        System.out.println("----------------------------------------------");
        Observer userLi = new User("人品");
        server.removeObserver(userZhang);
        server.registerObserver(userLi);
        server.setInfomation("com.enniu.service.rp.warn","cellphoneList");

    }
}
