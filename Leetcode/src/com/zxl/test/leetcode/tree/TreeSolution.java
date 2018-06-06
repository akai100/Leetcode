package com.zxl.test.leetcode.tree;

import com.zxl.test.leetcode.util.TreeNode;

/**
 * 树考点
 * @author Nada
 *
 */
public class TreeSolution {
	/**
	 * 获取最小深度
	 * @param node
	 * @param curDepth
	 * @return
	 */
	private int getMinDepthOfBinaryTree(TreeNode node, int curDepth)
	{
		if(node == null)
			return curDepth - 1;
		if(node.left == null && node.right == null)
			return curDepth;
		if(node.left == null)
			return getMinDepthOfBinaryTree(node.right, curDepth + 1);
		if(node.right == null)
			return getMinDepthOfBinaryTree(node.left, curDepth + 1);
		int leftMinDepth = getMinDepthOfBinaryTree(node.left, curDepth + 1);
		int rightMinDepth = getMinDepthOfBinaryTree(node.right, curDepth + 1);
		if (leftMinDepth < rightMinDepth)
			return leftMinDepth;
		else
			return rightMinDepth;
	}
	public int minimumDepthOfBinaryTree(TreeNode root)
	{
		return getMinDepthOfBinaryTree(root, 1);
	}
}
