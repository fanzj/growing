package com.jary.daily.grows.annoation.demo1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 下午2:09
 * 读取注解信息
 */
public class ReadAnnotationInfoTest {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.jary.daily.grows.annoation.demo1.AnnotationTest");
            Method[] methods = c.getDeclaredMethods();
            Annotation[] annotations;
            //遍历所有方法，得到方法上的注解信息
            for (Method method : methods) {
                annotations = method.getDeclaredAnnotations();
                System.out.println(method.getName());
                for (Annotation annotation : annotations) {
                    System.out.println("方法名为：" + method.getName() + ", 其上面的注解为：" + annotation.annotationType().getSimpleName());
                    Method[] mes = annotation.annotationType().getDeclaredMethods();
                    //遍历每个注解的所有变量
                    for(Method m:mes){
                        System.out.println("注解的变量名为："+m.getName());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
