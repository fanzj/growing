package com.jary.daily.grows.thread.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/25 下午4:34
 */
public class TestCountDownLatch {

    static class Student implements Runnable {

        private int num;
        private CountDownLatch latch;

        public Student(int num, CountDownLatch latch) {
            this.num = num;
            this.latch = latch;
        }

        @Override
        public void run() {
            doExam();
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Student " + num + " finished!");
            latch.countDown();
        }

        private void doExam() {
            System.out.println("Student " + num + " is doing the exam!!");
        }
    }

    static class Teacher implements Runnable {
        private CountDownLatch latch;

        public Teacher(CountDownLatch latch) {
            this.latch = latch;
        }


        @Override
        public void run() {
            try {
                System.out.println("teacher is waiting...");
                latch.await();
                System.out.println("teacher is collecting......");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);

        Student student1 = new Student(101,latch);
        Student student2 = new Student(102,latch);
        Student student3 = new Student(103,latch);
        Teacher teacher = new Teacher(latch);

        executor.execute(teacher);
        executor.execute(student1);
        executor.execute(student2);
        executor.execute(student3);

        executor.shutdown();
    }
}
