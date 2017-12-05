package com.jary.daily.grows.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/5 下午8:39
 */
public class JacksonTester {


    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        try {
            Student student = objectMapper.readValue(jsonString, Student.class);
            System.out.println(student);

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = objectMapper.writeValueAsString(student);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student {

    private String name;
    private int age;

    public Student() {

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

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}

