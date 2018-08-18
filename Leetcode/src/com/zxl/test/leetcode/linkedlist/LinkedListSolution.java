package com.zxl.test.leetcode.linkedlist;

import org.omg.CORBA.portable.ValueBase;

import com.zxl.test.leetcode.util.ListNode;
import com.zxl.test.leetcode.util.RandomListNode;

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
	
	/**
	 * 如果链表有循环则返回循环起始点，如果没有返回null。
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head)
	{
		ListNode node = head;
		while (node != null)
		{
			ListNode nextNode = node.next;
			ListNode tmpNode = head;
			while (tmpNode != null && tmpNode != node)
			{
				if (tmpNode == nextNode)
					return tmpNode;
				tmpNode = tmpNode.next;
			}
			if (nextNode == tmpNode)
				return tmpNode;
			node = node.next;
		}
		return null;
	}
	
	/**
	 * 不使用额外空间判断一个链表是否有环
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head)
	{
		return true;
	}
	
	/**
	 * 深度拷贝RandomList
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomListNode(RandomListNode head)
	{
		
		RandomListNode curNode = head, newHead;
		newHead = new RandomListNode(head.label);
		RandomListNode curNewNode = newHead;
		while(curNode != null)
		{
			curNode = curNode.next;
			RandomListNode tmpNode = new RandomListNode(curNode.label);
			curNewNode.next = tmpNode;
			curNewNode = curNewNode.next;
		}
		return newHead;
	}
	
	private RandomListNode search(RandomListNode head, RandomListNode node)
	{
		return null;
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int medianIndex = (A.length + B.length + 1) / 2;
		if ((A.length + B.length) % 2 == 0)
			medianIndex += 1;
			
		int d1 = 0, d2 = 0, index = 0, AIndex = 0, BIndex = 0;
		int position = 0;
		while(true)
		{
			if (AIndex < A.length && (BIndex >= B.length || A[AIndex] < B[BIndex]))
			{
				position = 0;
			}
			else if (BIndex < B.length && (AIndex >= A.length || B[BIndex] < A[AIndex]))
			{
				position = 1;
			}
			index += 1;
			if (index == medianIndex - 1)
			{
				d1 = position == 0 ? A[AIndex] : B[BIndex];
			}
			if (index == medianIndex)
			{
				d2 = position == 0 ? A[AIndex] : B[BIndex];
				break;
			}
			else
			{
				int tmp = position == 0 ? AIndex++ : BIndex++;
			}
		}
		
		return (A.length + B.length) % 2 == 0 ? (d1 + d2) / 2.0 : d2; 
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		return addTwoNumber(l1, l2, 0);
	}
	
	private ListNode addTwoNumber(ListNode l1, ListNode l2, int i)
	{
		if (l1 == null && l2 == null && i == 0)
			return null;
		i += (l1 == null ? 0 : l1.val);
		i += (l2 == null ? 0 : l2.val);
		ListNode node = new ListNode(i % 10);
		node.next = addTwoNumber(l1 == null ? null : l1.next, 
				l2 == null ? null : l2.next,  i / 10);
		return node;
	}
}
