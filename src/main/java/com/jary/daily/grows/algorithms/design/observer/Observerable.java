package com.jary.daily.grows.algorithms.design.observer;

/**
 * @author fanzhengjie
 * @create 2018/4/4 上午11:04
 * @description 抽象被观察者接口 （主题）
 * 声明了添加、删除、通知观察者方法
 */
public interface Observerable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();

}
