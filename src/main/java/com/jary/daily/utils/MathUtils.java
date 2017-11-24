package com.jary.daily.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/24 下午3:08
 */
public class MathUtils {

    private static final BigDecimal TEN_THOUSAND = new BigDecimal(10000);//1万

    public static String getRemainder(long id){
        return new DecimalFormat("00").format(id % 100);
    }

    public static String formatAmount(BigDecimal amount){
        String amountText = "";
        if(amount.compareTo(TEN_THOUSAND) >= 0){
            //大于等于1万
            long amountDigit = amount.longValue();
            if(amountDigit % TEN_THOUSAND.longValue() == 0){
                //可以整除1万
                DecimalFormat bigDigitFormat = new DecimalFormat("#,##0");
                long divideDigit = amountDigit / TEN_THOUSAND.longValue();
                String amountFormatStr = "+"+bigDigitFormat.format(divideDigit)+"万元";
                if(divideDigit>1000000l){
                    amountFormatStr = "+"+bigDigitFormat.format(divideDigit)+"万...";
                }
                amountText = amountFormatStr;
            }else{
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                BigDecimal divideResult = amount.divide(TEN_THOUSAND,2,BigDecimal.ROUND_HALF_UP);
                String divideResultFormatStr = decimalFormat.format(divideResult);
                String amountFormatStr = "+"+divideResultFormatStr+"万";
                if(divideResultFormatStr.length()>8){
                    amountFormatStr = "+"+divideResultFormatStr+"万...";
                }
                amountText = amountFormatStr;
            }
        }else{
            //小于1万
            DecimalFormat digitFormat = new DecimalFormat("#,##0");
            amountText = "+" + digitFormat.format(amount) + "元";
        }

        return amountText;
    }

    public static void main(String[] args){
       // System.out.println(getRemainder(127));
        System.out.println(formatAmount(new BigDecimal(213450000.234)));//1
        System.out.println(formatAmount(new BigDecimal(213456754.234)));//2
        System.out.println(formatAmount(new BigDecimal(14)));//3
        System.out.println(formatAmount(new BigDecimal(23)));
    }

}
