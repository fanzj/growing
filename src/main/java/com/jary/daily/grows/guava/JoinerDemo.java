package com.jary.daily.grows.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/2 下午7:15
 */
public class JoinerDemo {

    private static String join(List<String> list, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (Object item : list) {
            if (item != null) {
                builder.append(item).append(delimiter);
            }
        }
        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }

    /**
     * Joinner
     *
     * @param list
     * @param delimiter
     * @return
     */
    private static String joinByGuava(List<String> list, String delimiter) {
        return Joiner.on(delimiter).skipNulls().join(list);
    }

    /**
     * MapJoinner
     *
     * @return
     */
    private static String mapJoinner() {
        return Joiner.on("&").withKeyValueSeparator("=").join(ImmutableMap.of("id","123","name","Jack"));
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add(null);
        list.add("3");

        //   System.out.println(join(list,"++"));
        System.out.println(joinByGuava(list, "###"));
        System.out.println(mapJoinner());
    }
}
