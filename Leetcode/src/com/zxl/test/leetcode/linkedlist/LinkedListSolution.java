package com.zxl.test.leetcode.linkedlist;

import com.zxl.test.leetcode.util.ListNode;

public class LinkedListSolution {

	/**
	 * 对链表进行
	 * @param head
	 */
	public void reorderList(ListNode head) {
		ListNode curNode = head, preNode = null;
		while (curNode != null)
		{
			ListNode lastNode = curNode, lastPreNode = preNode;
			while (lastNode.next != null)
			{
				lastPreNode = lastNode;
				lastNode = lastNode.next;
			}
			if (lastNode != curNode)
			{
				lastPreNode.next = null;
				lastNode.next = curNode.next;
				curNode.next = lastNode;
				preNode = lastNode;
			}
			else {
				preNode = curNode;
			}
			curNode = preNode.next;
		}
    }
}
