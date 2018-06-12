package com.jary.daily.grows.reflect;

/**
 * @author fanzhengjie
 * @create 2018/6/11 下午7:33
 * @description
 */
public class Female extends Person{

    @Override
    public String say() {
        String word = "i am a woman";
        System.out.println(word);
        return word;
    }

    @Override
    public void eat() {
        System.out.println("i eat an banana");
    }
}
