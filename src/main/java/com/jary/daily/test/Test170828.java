package com.jary.daily.test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 下午3:21
 */
public class Test170828 {

    public static void main(String[] args){
       /* ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer == 10)
                list.remove(10);
        }*/

       ArrayList<String> list = new ArrayList<>();
       for(int i=0;i<10;i++){
           list.add("sh"+i);
       }
       for(int i=0;list.iterator().hasNext();i++){
           list.remove(i);
           System.out.println("result"+list.get(i));
       }



    }
}
