package com.jary.daily.grows.algorithms.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanzhengjie
 * @create 2018/4/4 上午11:05
 * @description 被观察者，也就是微信公众号服务 (主题)
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 */
public class WechatServer implements Observerable{

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String group;
    private String key;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty())
            list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(group,key);
        }
    }


    public void setInfomation(String group, String key) {
        this.group = group;
        this.key = key;
        System.out.println("group：" + group + ", key: "+key);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
