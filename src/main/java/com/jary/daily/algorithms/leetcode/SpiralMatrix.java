package com.jary.daily.algorithms.leetcode;

import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length==0)
			return list;
		int row = matrix.length, col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];
		int i = 0, j = 0;
		int count = 0;// ���ʸ���
		while (count < row * col) {
			while (j < col && !visited[i][j]) {// �����У���������
				list.add(matrix[i][j]);
				visited[i][j] = true;
				count++;
				j++;
			}
			i++;
			j--;
			while (i < row && !visited[i][j]) {// �����У����ϵ���
				list.add(matrix[i][j]);
				visited[i][j] = true;
				count++;
				i++;
			}
			i--;
			j--;
			while (j >= 0 && !visited[i][j]) {// �����У���������
				list.add(matrix[i][j]);
				visited[i][j] = true;
				count++;
				j--;
			}
			i--;
			j++;
			while (i >= 0 && !visited[i][j]) {// �����У����µ���
				list.add(matrix[i][j]);
				visited[i][j] = true;
				count++;
				i--;
			}
			i++;
			j++;

		}

		return list;
	}

	public static void main(String[] args) {
		SpiralMatrix matrix = new SpiralMatrix();
		int[][] A = { { 1 } };
		System.out.println(matrix.spiralOrder(A));
		int[][] B = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(matrix.spiralOrder(B));
		int[][] C = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(matrix.spiralOrder(C));
	}
}
