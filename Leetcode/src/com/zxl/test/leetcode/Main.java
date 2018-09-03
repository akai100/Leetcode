package com.zxl.test.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.zxl.test.leetcode.array.ArraySolution;
import com.zxl.test.leetcode.complexity.ComplexitySolution;
import com.zxl.test.leetcode.dynamicprogramming.DynamicProgrammingSolution;
import com.zxl.test.leetcode.exhaustive.ExhaustiveSolution;
import com.zxl.test.leetcode.exhaustive.Point;
import com.zxl.test.leetcode.linkedlist.LinkedListSolution;
import com.zxl.test.leetcode.other.OtherSolution;
import com.zxl.test.leetcode.sort.SortSolution;
import com.zxl.test.leetcode.string.StringSolution;
import com.zxl.test.leetcode.tree.TreeSolution;
import com.zxl.test.leetcode.util.ListNode;
import com.zxl.test.leetcode.util.TreeNode;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2&2&1);
		test_max_points();
		test_sortList();
		test_singleNumber2();
		test_hasPathSum();
		test_makeQueueRect();
		test_wordBreak();
		test_sumNumers();
		test();
		test_partition();
		test_lengthOfLongestSubstring();
		test_findMedianSortedArrays();
		test_longestPalindrome();
		test_convert();
		OtherSolution.other_solution_test();
		StringSolution.test();
		ArraySolution.test();
		LinkedListSolution.test();
	}
	
	public static void test_convert(){
		System.out.println("test convert...");
		System.out.println(StringSolution.convert("0123456789", 4));
	}
	
	public static void test_longestPalindrome(){
		System.out.println("test longestPalindrome...");
		System.out.println(StringSolution.longestPalindrome("cbbbde"));
	}
	public static void test_findMedianSortedArrays(){
		System.out.println("test findMedianSortedArrays...");
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		System.out.println(ArraySolution.findMedianSortedArrays(nums1, nums2));
	}
	public static void test_lengthOfLongestSubstring() {
		System.out.println("test lengthOfLongestSubstring2...");
		System.out.println(StringSolution.lengthOfLongestSubstring2("aaaabccbaea"));
		
	}
	public static void test(){
		long a = -91283472332l;
		System.out.println((int) a);
	}
	
	public static void test_partition() {
		ArrayList<ArrayList<String>> result = ArraySolution.partition("aab");
		for(ArrayList<String> item : result){
			for(String str : item) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	public static void test_sumNumers(){
		System.out.println("test sumNumers...");
		TreeNode root = new TreeNode(1);
		TreeNode node1 =new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		node1.left = node3;
		root.left = node1;
		root.right = node2;
		System.out.println(TreeSolution.sumNumbers(root));
	}
	public static void test_wordBreak(){
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		ArrayList<String> result = DynamicProgrammingSolution.wordBreak(s, dict);
		for(String str : result)
			System.out.println(str);
	}
	public static void test_makeQueueRect(){
		System.out.println("testing makeQueueRect()");
		int[][] result = OtherSolution.makeQueueRect(7);
		printArray(result);
	}
	public static void printArray(int[][] result){
		for(int i = 0; i < result.length; i ++){
			for(int j = 0; j < result.length; j++){
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static void test_isBalanced(){
		System.out.println("test isBalanced....");
		TreeNode root = createBTree();
		System.out.println(TreeSolution.isBalanced(root));
	}
	public static void test_hasPathSum(){
		System.out.println("test hasPathSum....");
		TreeNode root = createBTree();
		System.out.println(TreeSolution.hasPathSum(root, 3));
	}
	public static void test_singleNumber2(){
		int []A = {2, 2, 1};
		System.out.println(ComplexitySolution.singleNumber2(A));
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
	
	public static TreeNode createBTree(){
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		root.left = node1;
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		return root;
	}

}
