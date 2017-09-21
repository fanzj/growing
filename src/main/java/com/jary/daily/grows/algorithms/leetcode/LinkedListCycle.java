package com.jary.daily.grows.algorithms.leetcode;


public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		//����޻�����fast���ߵ��յ�
		//��������Ϊ������fast->nextΪ��
		//��������Ϊż����fastΪ��
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			
			//����л�����fast�ᳬ��slowһȦ
			if(fast==slow){
				break;
			}
		}
		
		if(fast==null || fast.next==null)
			return false;
		else
			return true;
	}
	
	public ListNode insert(ListNode t,int x){
		if(t==null){
			t = new ListNode(x);
		}else {
			t.next = insert(t.next, x);
		}
		return t;
	}
	
	public void print(ListNode root){
		while(root!=null){
			System.out.print(root.val);
			if(root.next!=null)
				System.out.print("->");
			else
				System.out.println();
			root = root.next;
		}
	}

	public static void main(String[] args) {
		LinkedListCycle solution = new LinkedListCycle();
		int[] A = {1,2,3,4,5};
		ListNode root = null;
		for(int i=0;i<A.length;i++){
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		System.out.println(solution.hasCycle(root));
	}
}
