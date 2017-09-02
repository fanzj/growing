package com.jary.daily.algorithms;

/**
 * 
 * @author dell
 * @title KMP
 * @description
 */
public class KMP {

	public int[] getNext(String subStr) {
		int[] next = new int[subStr.length()];
		int i = 0, k = -1;
		next[0] = -1;
		while (i < subStr.length() - 1) {
			if (k == -1 || subStr.charAt(i) == subStr.charAt(k)) {
				i++;
				k++;
				if (subStr.charAt(i) != subStr.charAt(k)) {
					next[i] = k;
				} else {
					next[i] = next[k];
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}

	/**
	 * kmp匹配，若t存在于s中，返回第一次出现的位置，否则，返回-1
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public int kmp(String s, String t) {
		int[] next = getNext(t);
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (j == -1 || s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j >= t.length())
			return i - t.length();
		else
			return -1;
	}
	
	public static void main(String[] args) {
		KMP kmp = new KMP();
		String s = "BBC ABCDAB ABCDABCDABDE";
		String t = "ABCDABD";
		System.out.println(kmp.kmp(s, t));
	}
	

}
