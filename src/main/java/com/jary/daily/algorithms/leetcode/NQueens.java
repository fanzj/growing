package com.jary.daily.algorithms.leetcode;

import java.util.ArrayList;

public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
		int[] cols = new int[n];// ��ŰڷŽ����cols[i]=j��ʾ��i��Ϊ��j
		ArrayList<String[]> list = new ArrayList<>();
		arrange(cols, 0, n, list);
		return list;
	}

	/**
	 * 
	 * @param cols
	 * @param m
	 *            ��ǰ��
	 * @param n
	 *            n�ʺ�
	 * @param list
	 *            ��Ž��
	 */
	public void arrange(int[] cols, int m, int n, ArrayList<String[]> list) {
		boolean[] rows = new boolean[n];
		for (int i = 0; i < m; i++) {// �ҳ��Ե�ǰ��m��˵����Щ�в��ܰڷ�
			rows[cols[i]] = true;// m���ܰڷ���cols[i]��
			int d = m - i;
			if (cols[i] - d >= 0)
				rows[cols[i] - d] = true;// m���ܰڷ���i��б�Խ�
			if (cols[i] + d < n)
				rows[cols[i] + d] = true;// m���ܰڷ���i�ķ�б�Խ�
		}
		for (int i = 0; i < n; i++) {// ������
			if (rows[i])
				continue;
			cols[m] = i;//m�аڷ���i
			if(m<n-1){//�������һ��
				arrange(cols, m+1, n, list);
			}else {
				//�������
				String[] s = new String[n];
				for(int j=0;j<n;j++){//��
					StringBuffer sb = new StringBuffer();
					for(int k=0;k<n;k++){
						if(j==cols[k])
							sb.append("Q");
						else
							sb.append(".");
					}
					s[j] = sb.toString();
				}
				list.add(s);
			}
		}
	}

	public static void main(String[] args) {
		NQueens solution = new NQueens();
		ArrayList<String[]> res = solution.solveNQueens(8);
		for(int i=0;i<res.size();i++){
			String[] str = res.get(i);
			for(int j=0;j<str.length;j++){
				System.out.println(str[j]);
			}
			System.out.println();
		}
		System.out.println("�ⷨ��"+res.size());
	}
}
