package com.jary.daily.grows.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/2 下午6:20
 */
public class SplliterDemo {

    private static String readMaintainConfig() throws IOException {
        File file = ResourceUtils.getFile("classpath:config/maintain.json");
        String configStr = FileUtils.readFileToString(file);
        System.out.println(configStr);
        return configStr;
    }

    public static String maintainLabel() throws IOException {
        URL url = Resources.getResource("config/maintain.json");
        String configStr = Resources.toString(url, Charsets.UTF_8);
        return configStr;
    }

    private static MaintainLabel getLabel(String str){
        return JSON.parseObject(str, MaintainLabel.class);
    }

    /**
     * Splitter能构将一个字符串按照指定的分隔符拆分成可迭代遍历的
     * 字符串集
     */
    private static void testSplitter1(){
        String str = "四川省 成都市 金牛区";
        String result = Splitter.on(' ').split(str).toString();
        System.out.println(result);
        Iterator<String> it = Splitter.on(' ').split(str).iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    private static Map<String,String> mapSplitter(){
        Map<String,String> map = Splitter.on("&").withKeyValueSeparator("=").split("id=123&name=Jack");
        return map;
    }

    public static void main(String[] args) throws IOException {
       // testSplitter1();
       // readMaintainConfig();
        MaintainLabel label = getLabel(readMaintainConfig());
        System.out.println(label.getBank());
        System.out.println(label.getBusiness());
        System.out.println(label.getChannel());
        System.out.println(label.getPlatform());
        System.out.println(label.getType());

        System.out.println(mapSplitter());

        System.out.println("----------------");
        System.out.println(maintainLabel());
    }
}
