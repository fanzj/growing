package com.jary.daily.algorithms.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		boolean isPositive = true;//�Ƿ�Ϊ����
		if(x<0){
			x = -x;
			isPositive = false;
		}
		int[] num = new int[20];
		int count = 0;
		while(x!=0){
			num[count++] = x%10;
			x/=10;
		}
		//ǰ��0ȥ��,��-1���棬��Щλ�ý�ȥ��
		for(int i=0;i<count;i++){
			if(num[i]!=0){
				break;
			}	
			else{
				num[i] = -1;
			}
		}
		x = 0;
		for(int i=0;i<count;i++){
			if(num[i]!=-1){
				x = x*10+num[i];
			}
		}
		if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){//�������
			x = 0;
		}
		if(!isPositive)
			x = -x;
		return x;
	}
	
	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int x1 = 10;
		int x2 = 1000;
		int x3 = 1000000003;
		int x4 = -12345;
		System.out.println(reverseInteger.reverse(x1));
		System.out.println(reverseInteger.reverse(x2));
		System.out.println(reverseInteger.reverse(x3));
		System.out.println(reverseInteger.reverse(x4));
	}
}
