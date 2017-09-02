package com.jary.daily.grows.annoation.demo2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/2 上午11:58
 */
public class ParseAnn {

    public static void main(String[] args){
        //1.使用类加载器加载类
        try {
            Class c = Class.forName("com.jary.daily.grows.annoation.demo2.Child");
            //2.找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist){
                //3.拿到注解实例
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.value());
            }

            //4.找到方法上的注解
            Method[] methods = c.getMethods();
            for(Method m : methods){
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if(isMExist){
                    Description d = m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }

            //另外一种解析方法
            for(Method m : methods){
                Annotation[] as = m.getAnnotations();
                for(Annotation a : as){
                    Description d = (Description) a;
                    System.out.println(d.value());
                }
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}
