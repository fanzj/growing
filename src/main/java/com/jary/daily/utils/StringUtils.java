package com.jary.daily.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/24 上午11:18
 */
public class StringUtils {

    //手机号正则匹配
    public static final Pattern MOBILE_REGX = Pattern.compile("^[1]\\d{10}$");

    //身份证号码正则匹配
    public static final Pattern IDENTITY_REGX = Pattern.compile("[1-9]\\d{13,16}[a-zA-Z0-9]");

    public static final String TEST_STR = "<font color=\"#999999\">%s</font>";

    public static void main(String[] args){
        BigDecimal num = new BigDecimal(6.66);
        System.out.println(String.format(TEST_STR,num.intValue()).replaceAll("#999999","#666666"));

        Matcher matcher = MOBILE_REGX.matcher("18868831807");
        if(matcher.find()){
            System.out.println(matcher.group());
        }

    }

}
