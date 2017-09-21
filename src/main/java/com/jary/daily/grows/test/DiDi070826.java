package com.jary.daily.grows.test;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/26 下午12:17
 */
public class DiDi070826 {

    class A{

        public void say(){
            System.out.println("A.say()");
        }
    }

    class B{

        public void speak(){
            System.out.println("B.speak()");
        }

    }

    private A a;
    private B b;

    public void doSth(){
        a.say();
        b.speak();
    }


    public static void main(String[] args) {

        DiDi070826 obj = new DiDi070826();
        DiDi070826.A a = obj.new A();
        a.say();

    }


}
