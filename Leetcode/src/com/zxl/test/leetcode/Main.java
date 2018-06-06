package com.zxl.test.leetcode;

import com.zxl.test.leetcode.linkedlist.LinkedListSolution;
import com.zxl.test.leetcode.util.ListNode;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListSolution solution = new LinkedListSolution();
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		solution.reorderList(head);
		ListNode curNode = head;
		while (curNode != null)
		{
			System.out.println(curNode.val);
			curNode = curNode.next;
		}
			
	}

}
