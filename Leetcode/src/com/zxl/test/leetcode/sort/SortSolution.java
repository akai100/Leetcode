package com.zxl.test.leetcode.sort;

import java.util.ArrayList;

import com.zxl.test.leetcode.util.ListNode;
import com.zxl.test.leetcode.util.TreeNode;

public class SortSolution {

	/**
	 * ��O(nlogn)ʱ�临�ӶȺͳ����ռ临�Ӷ��¶������������
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head){
		return null;
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
}
