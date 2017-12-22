package com.jary.daily.grows.cmp;

import java.util.Comparator;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/22 下午3:28
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGrade() > o2.getGrade()?1:-1;
    }
}
