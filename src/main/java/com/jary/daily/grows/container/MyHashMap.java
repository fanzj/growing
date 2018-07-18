package com.jary.daily.grows.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author fanzhengjie
 * @create 2018/7/2 下午5:11
 * @description
 */
public class MyHashMap<K,V> extends HashMap<K,V>{

    public List<V> get(String key, boolean like) {
        List<V> list = null;
        if (like) {
            list = new ArrayList<V>();
            K[] a = null;
            Set<K> set = this.keySet();
            Iterator<K> it = set.iterator();
            boolean more = it.hasNext();
            K elem = null;
            while(it.hasNext()) {
                elem = it.next();
                if(elem.toString().indexOf(key) == -1) {
                    continue;
                } else {
                    list.add(this.get(elem));
                }
            }
        }
        return list;
    }

}
