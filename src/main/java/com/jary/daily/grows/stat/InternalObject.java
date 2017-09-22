package com.jary.daily.grows.stat;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/22 下午3:10
 * 内部类测试
 */
public class InternalObject {

    private int id;
    protected String name;
    public static int age;

    private void say() {
        System.out.println("i'am not a static method say()");
    }

    public static void speak() {
        System.out.println("i'am a static method say()");
    }

    //非静态内部类
    class InternalA {
        private int address;
        private String school;
      //  private static String sex;//非静态内部类无法定义静态成员变量

        public void test() {
            say();//可访问外部非静态成员函数
            speak();//可访问外部静态成员函
            System.out.printf("%d %s %d\n", id, name, age);//可访问外部非静态成员变量和静态成员变量
        }

        //非静态内部类无法定义静态成员函数
       /* public static void test2() {

        }*/

    }

    //静态内部类
    static class InternalB {
        private int phone;
        private static boolean isChild;

        public void test() {
          //  System.out.println(id);
           // System.out.println(name);
            System.out.println(age);//只能访问外部类的静态成员变量

           // say();
            speak();//只能访问外部类的静态成员函数
        }

        public static void test4() {

        }
    }
}
