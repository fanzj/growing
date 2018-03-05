package com.jary.daily.grows.java8;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/22 下午9:18
 */
public class Test {

    /**
     * 合并多个流
     */
    private void test1(){
        List<String> list = Lists.newArrayList();
        list.add("I am a boy");
        list.add("I love the girl");
        list.add("But the girl loves another girl");

        List<String> result = list.stream()
            .map(line -> line.split(" "))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());
        System.out.println(result);

    }

    /**
     * 归约操作
     */
    private void test2(){
        List<Person> list = new ArrayList<>();
        {
            list.add(new Person("Jack",20));
            list.add(new Person("Bob", 18));
            list.add(new Person("Rose", 22));
        }

        int sum = list.stream().mapToInt(Person::getAge).sum();
        System.out.format("sum = %d\n",sum);
        int max = list.stream().mapToInt(Person::getAge).max().getAsInt();
        System.out.format("max = %d\n",max);
        int min = list.stream().mapToInt(Person::getAge).min().getAsInt();
        System.out.format("min = %d\n",min);
        double mean = list.stream().mapToInt(Person::getAge).average().getAsDouble();
        System.out.format("mean = %f\n",mean);
        String stat = list.stream().mapToInt(Person::getAge).summaryStatistics().toString();
        System.out.println(stat);
        double std = list.stream().mapToDouble(p -> (p.getAge() - mean) * (p.getAge() - mean)).sum();
        std = Math.sqrt(std / (list.size() - 1));
        System.out.format("std = %f\n",std);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }



    public static void main(String[] args) throws IOException {
        //Stream lines = Files.lines(Paths.get("文件路径名"), Charset.defaultCharset());
        Test test = new Test();
        test.test2();
    }

    class Person implements Comparable<Person>{
        private String name;
        private int age;
        public Person(){}
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }


        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.getAge(),o.getAge());
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
        }
    }
}
