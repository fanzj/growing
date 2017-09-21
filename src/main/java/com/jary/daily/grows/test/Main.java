package com.jary.daily.grows.test;

import java.util.Scanner;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/14 下午7:02
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String v_str[] = s1.split(" ");
        String w_str[] = s2.split(" ");
        int n = v_str.length;
        int v[] = new int[n];
        int w[] = new int[n];
        int maxId = Integer.MIN_VALUE;//最大候选人id


        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(v_str[i])-1;
            w[i] = Integer.parseInt(w_str[i]);
            maxId = Math.max(maxId,v[i]);

        }

        int candite[] = new int[maxId+1];//各个候选人的的票数
        int weight[] = new int[maxId+1];//各个候选人票选权重


        for (int i = 0; i < n; i++) {
            int id = v[i];
            weight[id] += w[i];
            candite[id] ++;
          //  System.out.println("v = "+v[i]+", weith = "+weight[id]);
        }



        int maxPos = 0,maxVal = weight[0];
        for(int i=1;i<=maxId;i++){
            if(weight[i]>maxVal){
                maxPos = i;
                maxVal = weight[i];
            }else if(weight[i] == maxVal){
                if(candite[i]>candite[maxPos]){
                    maxPos = i;
                    maxVal = weight[i];
                }
            }
        }

        System.out.println(maxPos+1);
    }
}
