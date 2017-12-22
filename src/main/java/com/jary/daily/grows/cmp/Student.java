package com.jary.daily.grows.cmp;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/22 下午3:27
 */
public class Student {

    private String name;
    private int age;
    private int grade;

    public Student(){}

    public Student(String name){
        this.name = name;
    }

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public Student(String name,int age,int grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", grade=" + grade +
            '}';
    }
}
