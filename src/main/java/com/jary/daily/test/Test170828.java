package com.jary.daily.test;

import java.math.BigDecimal;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 下午3:21
 */
public class Test170828 {

    public static void main(String[] args){
        BigDecimal a = BigDecimal.ZERO;
        a = new BigDecimal(1.2);


        System.out.println(a.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
    }
}
