package com.jary.daily.algorithms.leetcode;

public class UniqueBinarySearchTrees {

	//ѡ��һ���ڵ㣬�����������������ĳ˻������ܵĸ��������Եݹ���
	public int numTrees(int n) {
		if(n<=1)
			return 1;
		int num = 0;
		for(int i=1;i<=n;i++){
			num += numTrees(i-1)*numTrees(n-i);
		}
		return num;
	}
	
	//�ǵݹ�.��̬�滮
	public int numTrees2(int n) {
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++){
				dp[i] += dp[j-1]*dp[i-j];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees binarySearchTrees = new UniqueBinarySearchTrees();
		System.out.println(binarySearchTrees.numTrees2(3));
	}
}
