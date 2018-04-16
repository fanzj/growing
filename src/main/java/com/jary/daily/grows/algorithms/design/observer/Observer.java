package com.jary.daily.grows.algorithms.design.observer;

/**
 * @author fanzhengjie
 * @create 2018/4/4 上午11:03
 * @description 抽象观察者接口（订阅者）
 * 定义了一个update()方法，当被观察者(主题)调用notifyObservers()方法时，观察者的update()方法会被回调。
 */
public interface Observer {

    void update(String group, String key);

}
