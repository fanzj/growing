package com.jary.daily.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/20 上午10:12
 */
public class RegexUtils {

    public static boolean checkPhone(String phone) {
        //检查phone是否是合格的手机号
        boolean isPhone = phone.matches("1[358][0-9]{9,9}");
        return isPhone;
    }

    /**
     * 字符串匹配
     */
    private static void strMatch() {
        String str = "abcd12345efghijklmn";
        //检查str中间是否包含12345
        // \\w+一个或多个字符
        System.out.println(str + ":" + str.matches("\\w+12345\\w+")); //true
        System.out.println(str + ":" + str.matches("\\w+123456\\w+")); //false
    }

    /**
     * 字符串切割
     */
    private static void strSplit() {
        String str = "asfasf.sdfsaf.sdfsdfas.asdfasfdasfd.wrqwrwqer.asfsafasf.safgfdgdsg";
        String[] strs = str.split("\\.");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    /**
     * 查找
     */
    private static void getStrings() {
        String str = "rrwerqq84461376qqasfdasdfrrwerqq84461377qqasfdasdaa654645aafrrwerqq84461378qqasfdaa654646aaasdfrrwerqq84461379qqasfdasdfrrwerqq84461376qqasfdasdf";
        Pattern pattern = Pattern.compile("qq(.*?)qq");
        Matcher matcher = pattern.matcher(str);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 替换
     */
    private static void replace() {
        String str = "asfas5fsaf5s4fs6af.sdaf.asf.wqre.qwr.fdsf.asf.asf.asf";
        //将字符串中的.替换成_，因为.是特殊字符，所以要用\.表达，又因为\是特殊字符，所以要用\\.来表达.
        str = str.replaceAll("\\.", "_");
        System.out.println(str);
    }

    /**
     * 1.group是针对（）来说的，group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西
     */
    private static void test(){
        //匹配中文字符
        String s1 = "Java正则匹配Regex";
        System.out.println(s1.matches("Java[\u4e00-\u9fa5]{4}\\w+"));
        Pattern p1 = Pattern.compile("([\u4e00-\u9fa5])");
        Matcher m1 = p1.matcher(s1);
        while(m1.find()){
            System.out.println(m1.group(1));
        }

        //匹配国内电话号码
        String s2 = "0571-4405222";
        String s3 = "021-87888822";
        System.out.println(s2.matches("\\d{4}-\\d{7}|\\d{3}-\\d{8}"));
        System.out.println(s3.matches("\\d{4}-\\d{7}|\\d{3}-\\d{8}"));
    }

    private static void test2(){
        BigDecimal amount = new BigDecimal("52.3");
        System.out.println(amount.toString());
        Pattern pattern = Pattern.compile("^[-|+]?\\d*([.]\\d{0,2})?$");
        Matcher matcher = pattern.matcher(amount.toString());
        if (!matcher.find()) {
            System.out.println("充值金额不正确, 最多保留两位小数");
        }
        System.out.println("find");
    }

    public static void main(String[] args) {
        /*System.out.println("phone : " + checkPhone("13539770000"));
        System.out.println("phone : " + checkPhone("23539770000"));
        System.out.println("phone : " + checkPhone("17539770000"));
        strMatch();
        strSplit();
        getStrings();
        replace();
        System.out.println("=========================");
        test();*/

        test2();
    }
}
