package com.jary.daily.grows.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 下午2:03
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
public @interface Greeting {

    public enum FontColor{
        BLUE,
        RED,
        GREEN
    };

    String name();
    FontColor fontColor() default FontColor.RED;
}
