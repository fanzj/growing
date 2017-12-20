package com.jary.daily.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/20 下午5:57
 */
//@JsonIgnoreProperties({"name","age","title"})
    @JsonIgnoreProperties(ignoreUnknown = true)
public class JacksonIgnoreDO {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
