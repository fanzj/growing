package com.jary.daily.grows.test;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/25 下午6:27
 */
public class ZY {

    public static void main(String[] args) throws IOException {

        System.out.println(count(2));
    }

    public static BigDecimal count(int year){
        if(year==1)
            return BigDecimal.valueOf(10);
        return count(year-1).multiply(new BigDecimal(3)).subtract(new BigDecimal((year-1)*2));
       // return count(year-1)*3 - (year-1)*2;
    }
}
