package com.zxl.test.leetcode.linkedlist;

import java.util.Stack;

import com.zxl.test.leetcode.util.ListNode;
import com.zxl.test.leetcode.util.RandomListNode;

public class LinkedListSolution {


	/**
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k){
		if(head == null) return null;
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode node = head, newHead = null, preNode = null;
		while(true){
			ListNode tmp2 = node;
			while(stack.size() < k && node != null){
				stack.push(node);
				node = node.next;
			}
			if(stack.size() < k) {
				if(preNode != null)
					preNode.next = tmp2;
				break;
			}
			if(newHead == null) newHead = stack.peek();
			ListNode tmp = stack.pop();
			if (preNode != null) preNode.next = tmp;
			node = tmp.next;
			while(stack.size() > 0){
				tmp.next = stack.peek();
				tmp = stack.pop();
			}
			preNode = tmp;
		}
		if (newHead == null) newHead = head;
		return newHead;
	}
	public ListNode swapPairs(ListNode head){
		ListNode node1 = null;
		ListNode node2 = head;
		if(node2 == null) return head;
		ListNode node3 = node2.next;
		ListNode newHead = null;
		while(node2 != null && node3 != null){
			ListNode node = node3.next;
			node3.next = node2;
			node2.next = node;
			if (node1 == null) {
				newHead = node3;
			}else{
				node1.next = node3;
			}
			node1 = node2;
			if (node2 != null) node2 = node2.next;
			else break;
			if(node2 != null) node3 = node2.next;
			else break;
		}
		if (newHead == null) newHead = head;
		return newHead;
	}
	/**
	 * 合并k个顺序链表。
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists){
		int k = lists.length;
		ListNode head = null, preNode = null;
		ListNode [] curNodes = new ListNode[lists.length];
		for(int i = 0; i < k; i++){
			curNodes[i] = lists[i];
		}
		while(true){
			ListNode node = null;
			int min = 0;
			for(int i = 0; i < k; i++){

				if(node == null || (curNodes[i] != null &&curNodes[i].val < node.val)){
					node = curNodes[i];
					min = i;
				}
			}
			if (node == null) break;
			if (head == null) {
				head = node;
				ListNode tmp = node.next;
				if (node != curNodes[0]) node.next = curNodes[0];
				curNodes[min] = tmp;
				preNode = head;
			}else if(min == 0) {
				preNode = curNodes[0];
				curNodes[0] = curNodes[0].next;
			} else {
				ListNode tmp = node.next;
				preNode.next = node;
				preNode = node;
				node.next = curNodes[0];
				curNodes[min] = tmp;
			}

		}
		return head;
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head = l1, node1 = l1, node2 = l2;
		if (node2.val < node1.val){
			head = node2;
			node2 = node2.next;
			head.next = node1;
			node1 = head;

		}
		while(node2 != null){
			if(node1.next == null || node2.val <= node1.next.val) {
				ListNode tmp = node1.next;
				node1.next = node2;
				node2 = node2.next;
				node1.next.next = tmp;
				node1 = node1.next;
			}else{
				node1 = node1.next;
			}
		}
		return head;
	}
	/**
	 * 移除倒数第N个节点
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode nThNode = head, fastNode = head, nThPreNode = null;
		while(fastNode != null) {
			while(n != 0) {
				fastNode = fastNode.next;
				n--;
			}
			nThPreNode = nThNode;
			nThNode = nThNode.next;
			fastNode = fastNode.next;
		}
		if (nThPreNode == null){
			head = nThNode.next;
			nThNode.next = null;
			return head;
		}
		nThPreNode.next = nThNode.next;
		return head;
	}
	public int i = 0;

	public ListNode addTwoNumers(ListNode l1, ListNode l2) {

		ListNode node1 = l1, node2 = l2;
		ListNode newHead = null, preNode = newHead;
		int i = 0;
		while(node1 != null || node2 !=null){
			int value = 0;
			value += (node1 == null ? 0 : node1.val);
			value += (node2 == null ? 0 : node2.val);
			value += i;
			ListNode node = new ListNode(value % 10);
			i = value / 10;
			if(preNode == null){
				newHead = node;
			}else{
				preNode.next = node;
			}
			preNode = node;
			node1 = (node1 == null ? null : node1.next);
			node2 = (node2 == null ? null : node2.next);

		}
		if (i != 0)
			preNode.next = new ListNode(i);

		return newHead;
	}

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

	public static void test(){
		System.out.println("----------------test LinkedListSolution--------------");
		LinkedListSolution solution = new LinkedListSolution();
		System.out.println("test ");
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		ListNode node3 = new ListNode(4);
		node2.next = node3;
		ListNode node4 = new ListNode(5);
		node3.next = node4;
		ListNode newHead = solution.removeNthFromEnd(head, 2);
		ListNode node = newHead;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("test mergeTwoLists...");

		ListNode l1 = new ListNode(5);

		ListNode l2 = new ListNode(1);
		node1 = new ListNode(2);
		l2.next = node1;
		node2 = new ListNode(4);
		node1.next = node2;

		head = solution.mergeTwoLists(l1, l2);
		node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();

		System.out.println("test mergeKLists...");
		l1 = new ListNode(1);
		node1 = new ListNode(4);
		l1.next = node1;
		node2 = new ListNode(5);
		node1.next = node2;

		l2 = new ListNode(1);
		node1 = new ListNode(3);
		l2.next = node1;
		node2 = new ListNode(4);
		node1.next = node2;
		
		ListNode l3 = new ListNode(2);
		node1 = new ListNode(6);
		l3.next = node1;
		head = solution.mergeKLists(new ListNode[]{l1, l2, l3});
		node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		System.out.println("test swapPairs");
		l2 = new ListNode(1);
		node1 = new ListNode(3);
		l2.next = node1;
		node2 = new ListNode(4);
		node1.next = node2;
		node3 = new ListNode(5);
		node2.next = node3;
		head = solution.swapPairs(l2);
		node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		solution.testReverseKGroup();
	}
	
	private void  testReverseKGroup(){
		System.out.println("test reverseKGroup...");
		ListNode head = new ListNode(1);
		/*ListNode node1 = new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		ListNode node3 = new ListNode(4);
		node2.next = node3;
		ListNode node4 = new ListNode(5);
		node3.next = node4;*/
		head = reverseKGroup(head, 2);
		printLinkList(head);
	}
	
	private static void printLinkList(ListNode node){
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
}
