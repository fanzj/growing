package com.jary.daily.grows.guava;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/3 上午11:20
 */
public class GuavaDemo {

    private static void testMultiMap(){
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "e");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");

        List<String> lowerList = (List<String>) multimap.get("lower");
        System.out.println(lowerList.toString());

        Map<String,Collection<String>> map = multimap.asMap();
        for(Map.Entry<String,Collection<String>> entry : map.entrySet()){
            String key = entry.getKey();
            Collection<String> value = multimap.get(key);
            System.out.println(key+":"+value);
        }

        System.out.println(multimap.values());
    }

    private static void testOptional(){
        Integer value1 = null;
        Integer value2 = new Integer(10);
        Optional<Integer> a = Optional.fromNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        // add
        System.out.println("First parameter is present: "+a.isPresent());
        System.out.println("Second parameter is present: "+b.isPresent());
        Integer value3 = a.or(new Integer(0));
        Integer value4 = b.get();
        System.out.println("result = "+(value3+value4));

    }

    public static void main(String[] args) {
       // System.out.println(IntMath.binomial(5, 4));
       // testMultiMap();

        testOptional();
    }
}
