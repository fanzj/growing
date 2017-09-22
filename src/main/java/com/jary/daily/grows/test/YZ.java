package com.jary.daily.grows.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/21 下午7:53
 */
public class YZ {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] a = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                a[i][j] = in.nextInt();
                if(k==a[i][j]){
                    System.out.printf("%d %d\n",i,j);
                    return ;
                }
            }
        }
        System.out.println("-1 -1");




    }

    /*public static int binarySearch(int[] srcArray, int des){

        int low = 0;
        int high = srcArray.length-1;
        while(low <= high) {
            int middle = (low + high)/2;
            if(des == srcArray[middle]) {
                return middle;
            }else if(des <srcArray[middle]) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }*/
}
