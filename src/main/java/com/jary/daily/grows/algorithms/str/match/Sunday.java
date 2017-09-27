package com.jary.daily.grows.algorithms.str.match;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/22 下午8:59
 * 字符串匹配 - Sunday算法
 */
public class Sunday {

    /**
     * @param s 文本串
     * @param t 模式串
     * @return
     */
    public static void strMatch(String s, String t) {
        char[] destchars = s.toCharArray();
        char[] patternchars = t.toCharArray();

        int i = 0, j = 0, len1 = destchars.length, len2 = patternchars.length;
        while (i <= (len1 - len2 + j)) {
            if (destchars[i] != patternchars[j]) {
                if (i == (len1 - len2 + j)) {
                    break;
                }
                int pos = contains(patternchars, destchars[i + len2 - j]);
                if (pos == -1) {
                    i = i + len2 + 1 - j;
                    j = 0;
                } else {
                    i = i + len2 - pos - j;
                    j = 0;
                }
            } else {
                if(j == (len2 - 1)){
                    System.out.println("the start pos is "+(i-j)+" the end pos is "+i);
                    i = i - j + 1 ;
                    j = 0;
                }else{
                    i++;
                    j++;
                }
            }
        }

    }

    private static int contains(char[] chars, char target) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Sunday.strMatch("abcdebcdbcdebcde","bcde");

    }


}
