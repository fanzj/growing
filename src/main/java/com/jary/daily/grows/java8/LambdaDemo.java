package com.jary.daily.grows.java8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/7 下午5:16
 */
public class LambdaDemo {

    private static String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        StringBuilder builder = new StringBuilder();
        if(file.exists()){
            System.out.println("file existed");
            Path path = file.toPath();
            Files.lines(path, StandardCharsets.UTF_8).forEach(builder::append);
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        /*Arrays.asList("a","b","d").forEach(e -> System.out.println(e));
        Arrays.asList("a","b","d").forEach((String e) -> System.out.println(e));
        Arrays.asList("a","b","d").forEach(e -> {
            System.out.println(e);
            System.out.println(e);
        });*/
        /*List<String> list =  Arrays.asList("d","b","a","c");
        list.sort((e1,e2) -> e1.compareTo(e2));
        System.out.println(list);*/

        /*List<String> list =  Arrays.asList("d","b","a","c");
        list.sort((e1,e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
        System.out.println(list);*/

        String path = "/Users/fanzhengjie/growing/src/main/resources/config/maintain.json";
        System.out.println(readFile(path));
    }

}
