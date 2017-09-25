package com.jary.daily.grows.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/23 下午6:35
 */
public class Test {

 /*   class Person{
        private int age;
        public Person(int age){
            this.age = age;
        }
    }*/

    public static void main(String[] args){
        Test test = new Test();
        List<Person> list = new ArrayList<>();
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        for(final Person p:list){
            p.age = 20;
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(12);
        list1.add(13);
        for(final Integer x:list1){
           // x = 30;
        }

        /*int size = list.size();
        for(int i=0;i<size;size--){
            System.out.println(list.get(i).age);
            list.remove(i);
        }*/

        /*for(int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i).age);
            list.remove(i);
        }*/

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).age);


        }

    }
}
