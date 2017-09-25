package com.jary.daily.grows.basic;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/24 上午11:04
 * Java容器源码查看及测试
 */
public class Container {

    public static void main(String[] args) {
        HashSet<Integer> hashSet;
        HashMap<String, Integer> hashMap;
        LinkedHashMap<String, Integer> linkedHashMap;
        LinkedHashSet<Integer> linkedHashSet;

        Queue<Integer> queue = new ArrayDeque<>();//双向顺序队列
        Queue<Integer> queue1 = new LinkedList<>();//双向链式队列

        List<Integer> list = new ArrayList<Integer>();
        ConcurrentHashMap<String,Integer> map;


        Queue<Integer> queue2 = new PriorityQueue<>();//优先队列
        Queue<Integer> queue3 = new PriorityBlockingQueue<>();
        Queue<Integer> queue4 = new ArrayBlockingQueue<>(5);
        Queue<Integer> queue5 = new LinkedBlockingQueue<>();
        Queue<Integer> queue6 = new LinkedBlockingDeque<>();


        Hashtable<String, Integer> hashtable;

        int[] a = {3,2,1,4,5};
        int[] b = Arrays.copyOf(a,3);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }


    }
}
