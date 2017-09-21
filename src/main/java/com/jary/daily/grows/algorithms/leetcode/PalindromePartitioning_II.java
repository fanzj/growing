package com.jary.daily.grows.algorithms.leetcode;


public class PalindromePartitioning_II {
	
	/**
	 * ��̬�滮dp���
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		if(s==null || s.length()==0)
			return 0;
		int[] dp = new int[s.length()];
		for(int i=0;i<s.length();i++){
			dp[i] = isPalindrome(s.substring(0, i+1))?0:i;
			for(int j=i;j>=1;j--){//1<=j<=i���Ӵ������ж�(j����ȡ0����Ϊ��j == 0�����ֱ�ʾ�жϣ�0��i��)
				if(isPalindrome(s.substring(j, i+1))){
					dp[i] = Math.min(dp[i], dp[j-1]+1);
				}
			}
		}
		return dp[s.length()-1];
	}
	
	
	/**
	 * �Ƿ�Ϊ���Ĵ�
	 * @param s
	 * @return
	 */
	private boolean isPalindrome(String s){
		int n = s.length();
		for(int i=0;i<n/2;i++){
			if(s.charAt(i)!=s.charAt(n-1-i))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning_II solution = new PalindromePartitioning_II();
		String s = "ACDCDCDAD";
		System.out.println(solution.minCut(s));
	}
}
