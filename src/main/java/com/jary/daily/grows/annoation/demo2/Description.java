package com.jary.daily.grows.annoation.demo2;

import java.lang.annotation.*;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/2 上午10:51
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    String value();
}
