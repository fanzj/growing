package com.jary.daily.utils;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/20 下午12:13
 */
public class IOUtils<T> {

    public void print(T[] t){
        for(int i=0;i<t.length;i++){
            System.out.print(t[i]);
            if(i<t.length-1)
                System.out.print(" ");
            else
                System.out.println();
        }
    }
}
