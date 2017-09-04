package com.jary.daily.grows.reflect.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/4 下午2:23
 */
public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable{
        //1.通过类加载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.jary.daily.grows.reflect.demo2.Car");

        //2.获取类的默认构造器对象并通过它实例化
        Constructor constructor = clazz.getDeclaredConstructor(null);
        Car car = (Car) constructor.newInstance();

        //3.通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗CA72");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        initByDefaultConst().introduce();
    }


}
