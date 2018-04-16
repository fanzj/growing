package com.jary.daily.grows.algorithms.design.observer;

/**
 * @author fanzhengjie
 * @create 2018/4/4 上午11:07
 * @description
 */
public class User implements Observer{

    private String name;
    private String group;
    private String key;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String group, String key) {
        this.group = group;
        this.key = key;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + group+ " "+key);
    }

}
