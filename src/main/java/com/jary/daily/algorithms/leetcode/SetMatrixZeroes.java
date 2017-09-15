package com.jary.daily.algorithms.leetcode;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;// ��
		int n = matrix[0].length;// ��
		int[] rows = new int[m + n];
		int[] cols = new int[m + n];
		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[k] = i;
					cols[k++] = j;
				}
			}
		}
		for (int i = 0; i < k; i++) {
			// ��ÿ�д���
			for (int j = 0; j < n; j++) {
				matrix[rows[i]][j] = 0;
			}
			// ��ÿ�д���
			for (int j = 0; j < m; j++) {
				matrix[j][cols[i]] = 0;
			}
		}

	}

	public void setZeroes2(int[][] matrix) {
		boolean row = false, col = false;
		int m = matrix.length;// ����
		int n = matrix[0].length;// ����
		// �жϵ�һ�к͵�һ���Ƿ����㣬��ֹ������
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				col = true;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				row = true;
				break;
			}
		}
		// ���������õ�һ�к͵�һ�м�¼0��λ��
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// ���ݼ�¼����
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		// ������һ��
		if (row) {
			for (int i = 0; i < n; i++)
				matrix[0][i] = 0;
		}
		if (col) {
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes solution = new SetMatrixZeroes();
		int[][] A = { { 1, 2, 3, 4 }, { 5, 6, 0, 8 }, { 0, 9, 10, 11 }, { 12, 13, 0, 0 }, { 14, 0, 15, 16 } };
		solution.setZeroes2(A);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.print(A[i][j]);
				if (j < A[0].length - 1)
					System.out.print(" ");
				else
					System.out.println();
			}
		}
	}
}
