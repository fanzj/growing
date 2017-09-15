package com.jary.daily.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
	
	//�Լ������
	public int singleNumber(int[] A){
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<A.length;i++){
			if(!list.contains(A[i])){
				list.add(A[i]);
			}	
			else{
				list.remove((Integer)A[i]);
			}	
		}
		return list.get(0);
	}
	
	//���õ�˼·
	public int singleNumber2(int[] A){
		int num = A[0];
		for(int i=1;i<A.length;i++){
			num ^= A[i];//��ͬ�������Ϊ0��0��һ����������Ǹ���
		}
		return num;		
	}
	
	public static void main(String[] args) {
		int[] a = {1,4,6,73,5,123,4,1,6,123,5};
		System.out.println(new SingleNumber().singleNumber2(a));
	}
}
