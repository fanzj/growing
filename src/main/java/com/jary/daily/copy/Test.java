package com.jary.daily.copy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.util.SerializationUtils;

/**
 * @author fanzhengjie
 * @create 2018/10/10 下午9:12
 * @description
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Grade grade1 = new Grade(50);
        Student student1 = new Student(20, "Jack", grade1);
        List<Grade> gradeList = Arrays.asList(grade1);
        student1.setGradeList(gradeList);
        student1.setDate(new Date());
        student1.setNo(142);

        System.out.println("原始student1："+student1);
        Student student2 = new Student();
        BeanUtils.copyProperties(student1, student2);
        //student2 = (Student) student1.clone();
        grade1.setGrade(80);
        student1.setNo(12);
        System.out.println("改动后student1："+student1);
        System.out.println("student2："+student2);

    }

    static class Student implements Cloneable{
        int age;
        String name;
        Grade grade;
        List<Grade> gradeList;
        Date date;
        Integer no;

        public Student(){

        }

        public Student(int age, String name, Grade grade){
            this.age = age;
            this.name = name;
            this.grade = grade;
        }

        public Student(int age, String name, Grade grade, List<Grade> gradeList){
            this(age, name, grade);
            this.gradeList = gradeList;
        }


        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Grade getGrade() {
            return grade;
        }

        public void setGrade(Grade grade) {
            this.grade = grade;
        }

        public List<Grade> getGradeList() {
            return gradeList;
        }

        public void setGradeList(List<Grade> gradeList) {
            this.gradeList = gradeList;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }


        public Integer getNo() {
            return no;
        }

        public void setNo(Integer no) {
            this.no = no;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Student student = null;
            student = (Student) super.clone();
            student.grade = (Grade) this.grade.clone();
            return student;
        }

        @Override
        public String toString() {
            return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", gradeList=" + gradeList +
                ", date=" + date +
                ", no=" + no +
                '}';
        }
    }

    static class Grade implements Cloneable{
        double grade;

        public Grade(double grade){
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Grade{" +
                "grade=" + grade +
                '}';
        }
    }
}
