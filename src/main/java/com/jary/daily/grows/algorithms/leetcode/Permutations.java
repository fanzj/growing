package com.jary.daily.grows.algorithms.leetcode;

import java.util.ArrayList;

public class Permutations {
	/**
	 * �ǵݹ�
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for(int i=0;i<num.length;i++){//������Ӹ���Ԫ��
			ArrayList<ArrayList<Integer>> current = new ArrayList<>();
			for(ArrayList<Integer> r:result){
				for(int j=0;j<r.size()+1;j++){//num[i]����λ��j
					r.add(j,num[i]);
					current.add(new ArrayList<Integer>(r));
					r.remove(j);
				}
			}
			result = new ArrayList<>(current);
		}
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> permute2(int[] num) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> num2 =  new ArrayList<>();
		for(int i=0;i<num.length;i++)
			num2.add(num[i]);
		permutation(ans, num2, 0);
		return ans;
	}
	
	public void permutation(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> num,int l){
		if(l==num.size()-1)
			ans.add(new ArrayList<>(num));
		else {
			int temp = 0;
			for(int i=l;i<num.size();i++){
				temp = num.get(l);
				num.set(l, num.get(i));
				num.set(i, temp);
				permutation(ans, num, l+1);
				temp = num.get(l);
				num.set(l, num.get(i));
				num.set(i, temp);
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations solution = new Permutations();
		int[] num = {1,2,3};
		System.out.println(solution.permute2(num));
	}
}
