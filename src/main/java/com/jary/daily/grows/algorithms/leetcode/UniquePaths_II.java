package com.jary.daily.grows.algorithms.leetcode;

public class UniquePaths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;//����
		int n = obstacleGrid[0].length;//����
		int[][] path = new int[m][n];
		for(int i=0;i<m;i++){//�����һ��
			if(obstacleGrid[i][0]==1){//�ϰ�
				path[i][0] = 0;
				break;
			}else {
				path[i][0] = 1;
			}
		}
		for(int i=0;i<n;i++){//�����һ��
			if(obstacleGrid[0][i]==1){//�ϰ�
				path[0][i] = 0;
				break;
			}else {
				path[0][i] = 1;
			}
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(obstacleGrid[i][j]==1){
					path[i][j] = 0;
				}else {
					path[i][j] = path[i-1][j]+path[i][j-1];
				}
			}
		}
		return path[m-1][n-1];
	}
	
	public static void main(String[] args) {
		UniquePaths_II solution = new UniquePaths_II();
		int[][] A = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(solution.uniquePathsWithObstacles(A));
		int[][] B = {{0,0,1,0,0},{0,0,1,0,1},{1,0,0,0,0}};
		System.out.println(solution.uniquePathsWithObstacles(B)  );
	}
}
