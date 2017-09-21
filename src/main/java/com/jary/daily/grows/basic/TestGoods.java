package com.jary.daily.grows.basic;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/20 下午6:18
 */
public class TestGoods {

    public static void main(String[] args){
        Goods p = new Goods();
        Contents c = p.cont();
        Destination d = p.dest("Beijing");
    }
}
