package com.jary.daily.grows.thread.threadlocal;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/13 下午5:01
 * ThreadLocal Demo
 */
public class SequenceNumber {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    private static class TestClient extends Thread{
        private SequenceNumber sn;
        public TestClient(SequenceNumber sn){
            this.sn = sn;
        }

        @Override
        public void run() {
            for(int i=0;i<3;i++){//每个线程打出三个序列值
                System.out.println("thread["+Thread.currentThread().getName()+"] sn["+sn.getNextNum()+"]");
            }
        }
    }

    public static void main(String[] args){
        SequenceNumber sn = new SequenceNumber();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();
    }

}
