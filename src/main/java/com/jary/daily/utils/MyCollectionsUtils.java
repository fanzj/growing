package com.jary.daily.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/19 下午5:09
 */
public class MyCollectionsUtils {

    /**
     * A交B
     *
     * @param a
     * @param b
     * @return
     */
    public static Set<Integer> Communal(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int j = 0; j < b.length; j++) {
            boolean isSuc = set.add(b[j]);
            if (!isSuc) {
                set2.add(b[j]);
            }
        }
        return set2;
    }

    public static void print(Set<Integer> set){
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 14, 5, 3};
        int[] b = {1, 2, 4, 6, 3};
        Set<Integer> set = Communal(a,b);
        System.out.println("A交B=");
        print(set);

    }


}
