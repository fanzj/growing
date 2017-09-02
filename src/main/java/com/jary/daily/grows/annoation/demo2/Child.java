package com.jary.daily.grows.annoation.demo2;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/2 上午10:55
 */
@Description("I'm a child.")
public class Child implements Person{

    @Override
    @Description("名称")
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }
}
