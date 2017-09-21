package com.jary.daily.grows.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber_II {
	
	//�Լ�����⣬error
	public int singleNumber(int[] A){
		Arrays.sort(A);
		int count = 1;
		int res = 0;
		for(int i=0;i<A.length-1;i++){
			if(A[i]==A[i+1]){
				count++;
			}else if(count!=3){
				res = A[i];
				break;
			}else if(i==A.length-2){
				res = A[A.length-1];
			}else {
				count=1;
			}
		}
		
		return res;
	}
	
	//���õ�˼·(HashMap) Accept
	public int singleNumber2(int[] A){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<A.length;i++){
			if(!map.containsKey(A[i])){
				map.put(A[i], 1);
			}else if(map.get(A[i])<3){
				int value = map.get(A[i]);
				value ++;
				if(value==3)
					map.remove(A[i]);
				else
					map.put(A[i],value);
			}
		}
		int res = 0;
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			res = entry.getKey();
		}
		return res;
	}
	
	/**
	 * λ���� Accept
	 * ��������������32λ�����ƽ���ÿһλ�ϵ���1����  ���Ϊ3n��3n+1
     * Ϊ3n+1����Щλ����ֻ����һ�ε����Ķ�������1���ڵ�λ
	 * @param A
	 * @return
	 */
	public int singleNumber3(int[] A){
		int[] bit = new int[32];
		int res = 0;
		for(int i=0;i<32;i++){
			for(int j=0;j<A.length;j++){
				bit[i] += (A[j]>>i)&1;
			}
			//bit[i]Ϊ3n��3n+1
			//3n+1��ΪҪ�ҵ����Ķ�����λ1����λ
			res |= (bit[i]%3)<<i; //��3n+1����Щλ��1�ƻ�ԭλ
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {1,4,6,123,5,123,4,1,6,123,5,73,4,1,6,5};
		System.out.println(new SingleNumber_II().singleNumber3(a));
		
	}
}
