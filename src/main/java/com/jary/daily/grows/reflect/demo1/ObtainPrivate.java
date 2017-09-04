package com.jary.daily.grows.reflect.demo1;

import java.lang.reflect.Field;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 下午7:47
 * 反射机制获取private成员变量
 */
public class ObtainPrivate {

    public static void main(String[] args){
        try {
            Class c = Class.forName("com.jary.daily.grows.reflect.Person");
            Person p = new Person();
            p.setName("Java");
            p.setAge(20);
            p.setSex("男");
            p.setAddress("杭州");
            Field[] fields = c.getFields();
            for(int i=0;i<fields.length;i++){
                fields[i].setAccessible(true);
                System.out.println(fields[i].getName()+" = "+fields[i].get(p));
            }
            Field f = Person.class.getDeclaredField("name");
            f.setAccessible(true);
            System.out.println(f.getName()+" = "+f.get(p));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
