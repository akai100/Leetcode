package com.zxl.test.leetcode.sort;

import java.util.ArrayList;

import org.w3c.dom.Node;

import com.zxl.test.leetcode.util.ListNode;
import com.zxl.test.leetcode.util.TreeNode;

public class SortSolution {

	/**
	 * ��O(nlogn)ʱ�临�ӶȺͳ����ռ临�Ӷ��¶������������,
	 * ���Ӷ�Ҫ��ΪO(nlogn)����ʹ�ù鲢����
	 * ��һ��������ҵ��м�ڵ�
	 * �ڶ��������ʵ������
	 * @param head
	 * @return
	 */
	public static ListNode sortList(ListNode head){
		if (head == null || head.next == null) return head;
		ListNode middleNode = findMiddle(head);
		ListNode rightListNode =sortList(middleNode.next);
		middleNode.next = null;
		ListNode leftListNode = sortList(head);
		ListNode mergedList = mergeTwoList(leftListNode, rightListNode);
		return mergedList;
	}
	
	/**
	 * ���ҵ�������м�ڵ�
	 * @param head
	 * @return
	 */
	public static ListNode findMiddle(ListNode head) {
		if(head == null) return null;
		ListNode fastNode = head.next;
		ListNode slowNode = head;
		while(fastNode != null && fastNode.next != null){
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return slowNode;
	}
	/**
	 * �ϲ�������������
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode mergeTwoList(ListNode head1, ListNode head2){
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while(head1 != null && head2 != null) {
			if(head1.val < head2.val){
				node.next = head1;
				head1 = head1.next;
			} else{
				node.next = head2;
				head2 = head2.next;
			}
			node = node.next;
		}
		if (head1 == null)
			node.next = head2;
		if (head2 == null)
			node.next = head1;
		return dummy.next;
	}
	
	/**
	 * ʹ�ò������򷨶������������
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head)
	{
		if (head == null)
			return head;
		ListNode curNode = head.next;
		ListNode curPreNode = head;
		while (curNode != null)
		{
			ListNode sortedCurNode = head;
			ListNode sortedCurPreNode = null;
			while(sortedCurNode != curNode && curNode.val >sortedCurNode.val)
			{
				sortedCurPreNode = sortedCurNode;
				sortedCurNode = sortedCurNode.next;
			}
			if (curNode == sortedCurNode)
			{
				curPreNode = curNode;
				curNode = curNode.next;
				continue;
			}
			if (sortedCurPreNode == null) // ���뵽ͷ�ڵ�
			{
				curPreNode.next = curNode.next;
				curNode.next = head;
				head = curNode;
			}
			else {
				curPreNode.next = curNode.next;
				sortedCurPreNode.next = curNode;
				curNode.next = sortedCurNode;
			}
			curNode = curPreNode.next;
		}
		return null;
	}
	
	/**
	 * �������������
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		postorderTraversal(root, result);
		return result;
	}
	
	private void postorderTraversal(TreeNode node, ArrayList<Integer> result)
	{
		if (node == null)
			return;
		postorderTraversal(node.left, result);
		postorderTraversal(node.right, result);
		result.add(node.val);
	}
	
	/**
	 * ǰ�����������
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		preorderTraversal(root, result);
		return result;
    }
	private void preorderTraversal(TreeNode node, ArrayList<Integer> result) {
		if (node == null)
			return;
		result.add(node.val);
		preorderTraversal(node.left, result);
		preorderTraversal(node.right, result);
	}
	
	
	/**
	 * ��������СΪm��n����������A��B. �������������������λ����
	 *  �ܵ�����ʱ�临�Ӷ�Ӧ����O��log��m + n������
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		return 0.0;
	}
}
