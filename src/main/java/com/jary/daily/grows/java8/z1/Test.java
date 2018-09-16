package com.jary.daily.grows.java8.z1;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author fanzhengjie
 * @create 2018/7/18 上午9:57
 * @description
 */
public class Test {

    public static void main(String[] args){

    }

    public static void testListHiddenFile(){
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        hiddenFiles = new File(".").listFiles(File::isHidden);
    }

    public static void testApple(){
        List<Apple> list = Lists.newArrayList();
        list.stream().filter((Apple a) -> a.getWeight()>100).collect(Collectors.toList());
    }

}
