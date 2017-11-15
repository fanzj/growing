package com.jary.daily.grows.thread.task;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/14 下午5:37
 */
public class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            BigInteger p = BigInteger.ONE;
            while(!cancelled){
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel(){
        cancelled = true;
    }
}

class Consumer{

    public void consumePrimes(){
        BlockingQueue<BigInteger> primes = new LinkedBlockingQueue<>();
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try{
           // while(needMorePrimes()){
                consume(primes.take());
           // }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            producer.cancel();
        }
    }

    private void consume(BigInteger x){
        System.out.print(x);
    }
}
