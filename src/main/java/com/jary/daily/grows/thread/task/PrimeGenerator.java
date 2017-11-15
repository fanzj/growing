package com.jary.daily.grows.thread.task;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/14 下午5:02
 */
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    public static void main(String[] args){
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            generator.cancel();
        }
        System.out.println(generator.get());
    }

}
