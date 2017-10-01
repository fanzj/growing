package com.jary.daily.grows.thread.exception;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/29 上午11:41
 */
public class NoCaughtThread {

    public static void main(String[] args){
        try{
            new Thread(new Task()).start();
        }catch (Exception e){
            System.out.println("==Exception: "+e.getMessage());
        }
    }

}
