package com.jary.daily.grows.algorithms.leetcode;

public class SearchA2dMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;//��
		int n = matrix[0].length;//��
		int t_row = -1;//Ŀ��������
		int i;
		for(i=0;i<m-1;i++){
			if(target>=matrix[i][0] && target <matrix[i+1][0]){
				t_row = i;
				break;
			}
		}
		if(i==m-1 && target>=matrix[i][0]){//���һ��
			t_row = i;
		}
		if(t_row==-1)
			return false;
		
		for(int j=0;j<n;j++){
			if(target==matrix[t_row][j]){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SearchA2dMatrix solution = new SearchA2dMatrix();
		int[][] A = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		//int[][] A = {{1}};
		System.out.println(solution.searchMatrix(A, 0));
	}
}
