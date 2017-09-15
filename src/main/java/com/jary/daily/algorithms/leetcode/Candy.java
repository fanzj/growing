package com.jary.daily.algorithms.leetcode;

import java.util.Arrays;

public class Candy {
	
	/**
	 * error
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		int len = ratings.length;
		int minPos = 0;
		int minVal = ratings[0];
		int[] candies = new int[len];//��¼�Ѿ������
		int sum = 0;
		for(int i=0;i<len;i++){//����С
			if(minVal > ratings[i]){
				minVal = ratings[i];
				minPos = i;
			}
		}
		candies[minPos] = 1;
		sum += candies[minPos];
		
		for(int i=minPos+1;i<len;i++){//������С���Ҳ�
			if(ratings[i]>ratings[i-1]){
				candies[i] = candies[i-1]+1;
			}else{
				if(candies[i-1]>1)
					candies[i] = candies[i-1]-1;
				else
					candies[i] =1;
			}
			sum += candies[i];
		}
		for(int i=minPos-1;i>=0;i--){//������С�����
			if(ratings[i]>ratings[i+1]){
				candies[i] = candies[i+1]+1;
			}else{
				if(candies[i+1]>1)
					candies[i] = candies[i+1]-1;
				else
					candies[i] =1;	
			}
			sum += candies[i];
		}
		/*for(int i=0;i<len;i++){
			System.out.print(candies[i]+" ");
		}*/
		return sum;
	}
	
	
	public int candy2(int[] ratings) {
		if(ratings==null || ratings.length==0)
			return 0;
		int len = ratings.length;
		int candies[] = new int[len];
		Arrays.fill(candies, 1);//��ʼÿ��С������Ϊһ���ǹ�
		int sum = 0;
		for(int i=1;i<len;i++){//�������ұ���
			if(ratings[i]>ratings[i-1]){
				candies[i] = candies[i-1] + 1;
			}
		}
		for(int i=len-1;i>0;i--){//�����������
			if(ratings[i]<ratings[i-1] && candies[i] >= candies[i-1]){
				candies[i-1] = candies[i]+1;
			}
		}
		for(int i=0;i<len;i++){
			sum += candies[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Candy candy = new Candy();
	//	int ratings[] = {4,3,1,5,2};//9
	//	int ratings[] = {4,3,5,1,2};//8
	//	int ratings[] = {2,2};//2
	//	int ratings[] = {1,2,2};//4
		int ratings[] = {4,2,3,4,1};//9
		System.out.println("minimum candies = "+candy.candy2(ratings));
	}
}
