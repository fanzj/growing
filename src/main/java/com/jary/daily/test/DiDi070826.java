package com.jary.daily.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/26 下午12:17
 */
public class DiDi070826 {



   /* public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = in.nextInt();
        String[] numbuers = str.split(" ");
        int[] nums = new int[numbuers.length];
        for(int i=0;i<numbuers.length;i++){
            nums[i]= Integer.parseInt(numbuers[i]);
        }
        Arrays.sort(nums);
        System.out.println(nums[nums.length-k]);
    }*/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String numbers[] = str.split(" ");
        int nums[]=new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            nums[i]=Integer.parseInt(numbers[i]);
        }

        int sum = 0;
        int maxNow = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            maxNow = Math.max(maxNow, sum);
        }
        System.out.println(maxNow);

    }



}
