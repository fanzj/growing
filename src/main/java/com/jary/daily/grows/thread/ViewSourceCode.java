package com.jary.daily.grows.thread;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/9 下午2:42
 */
public class ViewSourceCode {

    Map<String,Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args){
        TimeUnit unit = TimeUnit.SECONDS;
        System.out.println(unit.toNanos(1));

    }

    private void test(){
        Charset charset = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = charset.encode("test");
        CharBuffer charBuffer = charset.decode(byteBuffer);
    }
}
