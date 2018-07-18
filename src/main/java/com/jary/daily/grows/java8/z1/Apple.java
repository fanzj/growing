package com.jary.daily.grows.java8.z1;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author fanzhengjie
 * @create 2018/7/5 上午10:41
 * @description
 */
public class Apple {

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
            "weight=" + weight +
            '}';
    }

    public static List<Apple> generateAppleList(){
        List<Apple> list = Lists.newArrayList();
        Apple a1 = new Apple();
        a1.setWeight(1);

        Apple a2 = new Apple();
        a2.setWeight(5);

        Apple a3 = new Apple();
        a3.setWeight(2);

        list.add(a1);
        list.add(a2);
        list.add(a3);
        return list;
    }
}
