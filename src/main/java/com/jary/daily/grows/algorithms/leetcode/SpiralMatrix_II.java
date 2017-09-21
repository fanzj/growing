package com.jary.daily.grows.algorithms.leetcode;

public class SpiralMatrix_II {

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int len = n*n;
		int i=0,j=0;//��ʾ��ǰ���ʵ��к���
		int cur = 1;
		while(cur<=len){
			for(;j<n && visited[i][j]==false;j++){//��i�У���������
				matrix[i][j] = cur ++;
				visited[i][j] = true;
			}
			i++;//������һ��
			j--;
			for(;i<n && visited[i][j]==false;i++){
				matrix[i][j] = cur ++;
				visited[i][j] = true;
			}
			i--;
			j--;
			for(;j>=0 && visited[i][j]==false;j--){
				matrix[i][j] = cur ++;
				visited[i][j] = true;
			}
			i--;
			j++;
			for(;i>=0 && visited[i][j]==false;i--){
				matrix[i][j] = cur ++;
				visited[i][j] = true;
			}
			i++;
			j++;
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		SpiralMatrix_II solution = new SpiralMatrix_II();
		int n = 10;
		int[][] matrix = solution.generateMatrix(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(String.format("%02d", matrix[i][j]));
				if(j<n-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
