package com.jary.daily.grows.sort;

import java.util.Arrays;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 下午8:16
 */
public class SortUtils {


    /**
     * 直接插入排序
     * 时间复杂度:平均O(n2);最好O(n);最坏O(n2)
     * 空间复杂度:O(1)
     * 稳定
     */
    public static class InsertSort {
        public static void sort(int[] a) {

            for (int i = 1; i < a.length; i++) {
                if (a[i] < a[i - 1]) {
                    int j = i - 1;
                    int x = a[i];//哨兵
                    //a[i] = a[i - 1];
                    while (j >= 0 && x < a[j]) {
                        a[j + 1] = a[j];
                        j--;
                    }
                    a[j + 1] = x;
                }
            }
        }
    }

    /**
     * 希尔排序
     * 时间复杂度:平均O(n1.3);最好O(n);最坏O(n2)
     * 空间复杂度:O(1)
     * 不稳定
     */
    public static class ShellSort {

        /**
         * 如果为直接插入排序，则dk=1
         *
         * @param a
         * @param dk
         */
        private static void shellInsertSort(int[] a, int dk) {
            for (int i = dk; i < a.length; i++) {
                if (a[i] < a[i - dk]) {
                    int j = i - dk;
                    int x = a[i];//哨兵
                    //a[i] = a[i - dk];
                    while (j >= 0 && x < a[j]) {
                        a[j + dk] = a[j];
                        j -= dk;
                    }
                    a[j + dk] = x;
                }
            }
        }

        public static void sort(int[] a) {
            int dk = a.length / 2;
            while (dk >= 1) {
                shellInsertSort(a, dk);
                dk /= 2;
            }
        }
    }

    /**
     * 简单选择排序
     * 时间复杂度:平均O(n2);最好O(n2);最坏O(n2)
     * 空间复杂度:O(1)
     * 不稳定
     */
    public static class SelectSort {

        public static void sort(int[] a) {
            for (int i = 0; i < a.length; i++) {
                //选出最小
                int pos = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[pos] > a[j]) {
                        pos = j;
                    }
                }
                //交换
                swap(a, pos, i);
            }
        }

        /**
         * 改进 - 二元选择排序
         *
         * @param a
         */
        public static void sort2(int[] a) {
            for (int i = 1; i <= a.length / 2; i++) {
                int min = i, max = i;//记录最小最大元素出现的位置
                for (int j = i + 1; j <= a.length - i; j++) {
                    if (a[j] > a[max]) {
                        max = j;
                        continue;
                    }
                    if (a[j] < a[min]) {
                        min = j;
                    }
                }
                swap(a, i - 1, min);
                swap(a, a.length - i, max);
                System.out.format("第%d趟排序结果：%s\n", i, Arrays.toString(a));
            }
        }
    }

    /**
     * 堆排序
     * 时间复杂度:平均O(nlogn);最好O(nlogn);最坏O(nlogn)
     * 空间复杂度:O(1)
     * 不稳定
     */
    public static class HeapSort {

        /**
         * 堆调整
         *
         * @param h
         * @param s 待调整的数组元素位置
         */
        private static void heapAdjust(int[] h, int s, int len) {
            int tmp = h[s];
            int child = 2 * s + 1;//左孩子节点位置
            while (child < len) {
                if (child + 1 < len && h[child] < h[child + 1]) {
                    ++child;
                }
                if (h[s] < h[child]) {
                    h[s] = h[child];
                    s = child;
                    child = 2 * s + 1;
                } else
                    break;

                h[s] = tmp;
            }
        }

        /**
         * 建堆
         *
         * @param h
         */
        private static void buildHeap(int[] h) {
            //最后一个有孩子的节点的位置i=(h.len-1)/2
            for (int i = (h.length - 1) / 2; i >= 0; i--) {
                heapAdjust(h, i, h.length);
            }
        }

        public static void sort(int[] h) {
            buildHeap(h);
            for (int i = h.length - 1; i > 0; i--) {
                swap(h, 0, i);
                heapAdjust(h, 0, i);
            }
        }

    }

    /**
     * 冒泡排序
     * 时间复杂度:平均O(n2);最好O(n);最坏O(n2)
     * 空间复杂度:O(1)
     * 稳定
     */
    public static class BubbleSort{
        public static void sort(int[] a){
            for(int i=0;i<a.length-1;i++){
                for(int j=0;j<a.length-1-i;j++){
                    if(a[j]>a[j+1]){
                        swap(a,j,j+1);
                    }
                }
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度:平均O(nlogn);最好O(nlogn);最坏O(n2)
     * 空间复杂度:O(nlogn)
     * 不稳定
     */
    public static class QuickSort{
        private static int partion(int[] a,int low,int high){
            int pivot = a[low];//基准
            while(low < high){
                while(low<high && a[high] >= pivot)
                    high--;
                swap(a,low,high);
                while(low < high && a[low] <= pivot)
                    low++;
                swap(a,low,high);
            }
            return low;
        }

        public static void sort(int[] a, int low, int high){
            if(low<high){
                int partion = partion(a,low,high);
                sort(a,low,partion-1);
                sort(a,partion+1,high);
            }
        }
    }

    /**
     * 归并排序
     * 时间复杂度:平均O(nlogn);最好O(nlogn);最坏O(nlogn)
     * 空间复杂度:O(n)
     * 稳定
     */
    public static class MergeSort{
        public static void merge(int[] array, int start1, int end1, int start2, int end2) {
            int i, j;// i,j分别为表1和表2的游标
            {
                i = start1;
                j = start2;
            }
            int k = 0;
            int[] temp = new int[end2 - start1 + 1];// 建立一个临时长度为两个子列表长度之和的数组

            while(i<=end1 && j<=end2){
                if(array[i]>array[j])
                    temp[k++] = array[j++];
                else
                    temp[k++] = array[i++];
            }
            //把剩下的元素依次放入临时数组中（肯定只剩下一方）
            while(i<=end1){
                temp[k++] = array[i++];
            }
            while(j<=end2){
                temp[k++] = array[j++];
            }

            System.arraycopy(temp, 0, array, start1, k);
        }

        public static void sort(int[] array,int start,int end){
            if(start<end){
                int mid = (start+end)/2;
                //两路归并
                sort(array, start, mid);
                sort(array, mid+1, end);
                merge(array, start, mid, mid+1, end);
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6};
      /*  System.out.println("直接插入排序前：" + Arrays.toString(a));
        InsertSort.sort(a);
        System.out.println("直接插入排序后：" + Arrays.toString(a));*/

      /*  System.out.println("希尔排序前：" + Arrays.toString(a));
        ShellSort.sort(a);
        System.out.println("希尔排序后：" + Arrays.toString(a));*/


        System.out.println("选择排序前：" + Arrays.toString(a));
        SelectSort.sort2(a);
        System.out.println("选择排序后：" + Arrays.toString(a));

   /*     System.out.println("堆排序前：" + Arrays.toString(a));
        HeapSort.sort(a);
        System.out.println("堆排序后：" + Arrays.toString(a));*/

     /*   System.out.println("冒泡排序前：" + Arrays.toString(a));
        BubbleSort.sort(a);
        System.out.println("冒泡排序后：" + Arrays.toString(a));*/

      /*  System.out.println("快速排序前：" + Arrays.toString(a));
        QuickSort.sort(a,0,a.length-1);
        System.out.println("快速排序后：" + Arrays.toString(a));*/

       /* System.out.println("归并排序前：" + Arrays.toString(a));
        MergeSort.sort(a,0,a.length-1);
        System.out.println("归并排序后：" + Arrays.toString(a));*/
    }


}
