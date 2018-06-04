package com.zxl.test.leetcode;

import com.zxl.test.leetcode.tree.TreeNode;
import com.zxl.test.leetcode.tree.TreeSolution;

import sun.reflect.generics.tree.Tree;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		root.right = node1;
		TreeSolution ts = new TreeSolution();
		System.out.println(ts.minimumDepthOfBinaryTree(root));
	}

}
