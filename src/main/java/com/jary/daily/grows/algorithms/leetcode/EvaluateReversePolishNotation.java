package com.jary.daily.grows.algorithms.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String element = tokens[i];
			switch (element) {
			case "+": {//�ж�Ϊ������,��ջ����������Ԫ��,��Ϊ�沨����ʾ�����ԣ��������϶��ڲ�����ǰ
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x+y);
			}
				break;
			case "-": {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x-y);
			}
				break;
			case "*": {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x*y);
			}
				break;
			case "/": {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x/y);
			}
				break;
			default: {//Ϊ���֣�ѹջ
				stack.push(Integer.valueOf(element));
			}
				break;
			}
			
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
		String[] tokens1 = { "2", "1", "+", "3", "*" };
		System.out.println(solution.evalRPN(tokens1));
		String[] tokens2 = { "4", "13", "5", "/", "+" };
		System.out.println(solution.evalRPN(tokens2));
	}
}
