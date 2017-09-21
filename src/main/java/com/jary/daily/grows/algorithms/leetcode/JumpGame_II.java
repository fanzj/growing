package com.jary.daily.grows.algorithms.leetcode;

public class JumpGame_II {
	public int jump(int[] A) {
		int[] dp = new int[A.length];// dp��ŵ��������С����
		for (int i = 0; i < dp.length; i++) {
			int max = Math.min(i + A[i], A.length - 1);// ��i��������ߵ���Զ����
			for (int j = i + 1; j <= max; j++) {
				if (dp[j] == 0)// ���λ��û���߹�,�򵽴�j��Ĳ���Ϊdp[i]+1
					dp[j] = dp[i] + 1;
			}
			if (dp[A.length - 1] != 0)// ����һ�ε����յ�ʱ,�϶��ǵ����յ���̵Ĳ���
				break;
		}
		return dp[A.length - 1];
	}

	public static void main(String[] args) {
		JumpGame_II solution = new JumpGame_II();
		int[] A = { 2, 3, 1, 1, 4 };
		System.out.println(solution.jump(A));
	}
}
