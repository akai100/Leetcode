package com.zxl.test.leetcode;

import com.zxl.test.leetcode.exhaustive.ExhaustiveSolution;
import com.zxl.test.leetcode.exhaustive.Point;
import com.zxl.test.leetcode.hash.HashSolution;
import com.zxl.test.leetcode.linkedlist.LinkedListSolution;
import com.zxl.test.leetcode.sort.SortSolution;
import com.zxl.test.leetcode.string.StringSolution;
import com.zxl.test.leetcode.util.ListNode;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_max_points();
		test_sortList();
	}
	
	public static void test_max_points() {
		Point []points = new Point[]{
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 1),
			new Point(1, 1),
			new Point(2, 2)
		};
		System.out.println("同一条直线上的最多的点的数目：" + ExhaustiveSolution.maxPoints(points));
	}
	
	public static void test_sortList() {
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(1);
		head.next = node1;
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		printList(SortSolution.sortList(head));
	}
	
	public static void printList(ListNode head) {
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

}
