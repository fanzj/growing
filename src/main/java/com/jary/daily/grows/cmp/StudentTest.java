package com.jary.daily.grows.cmp;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/22 下午3:29
 */
public class StudentTest {

    public static void main(String[] args){
        Student s1 = new Student("AAA",20,85);
        Student s2 = new Student("BBB",18,75);
        Student s3 = new Student("CCC",25,90);
        List<Student> list = Lists.newArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        System.out.println(list);
        Collections.sort(list,new StudentComparator());
        System.out.println(list);
    }
}
