package com.jary.daily.grows.reflect;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fanzhengjie
 * @create 2018/6/11 下午7:34
 * @description
 */
public class ClazzTest {

    public static final Map<String, Class> channelServiceMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        /*Map<String,Class> map = Maps.newHashMap();
        map.put("100", Female.class);
        map.put("101", Male.class);

        Class clazz = map.get("100");
        try {
            Object object = clazz.newInstance();
            Person person = (Person) object ;
            person.say();
            person.eat();
            person.sleep();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/


        channelServiceMap.put("100", Female.class);
        channelServiceMap.put("101", Male.class);

        Person person = getRealService("101");
        person.eat();
        person.say();
        person.sleep();
    }

    public static <T> T getRealService(String channelCode) throws IllegalAccessException, InstantiationException {
        Class<T> clazz = channelServiceMap.get(channelCode);
        Object object = clazz.newInstance();
        T realService = (T) object;
        return realService;
    }



}
