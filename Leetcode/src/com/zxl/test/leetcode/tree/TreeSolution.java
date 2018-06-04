package com.zxl.test.leetcode.tree;

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
		int leftMinDepth = getMinDepthOfBinaryTree(node.left, curDepth + 1);
		int rightMinDepth = getMinDepthOfBinaryTree(node.right, curDepth + 1);
		if ((rightMinDepth == 1|| leftMinDepth < rightMinDepth) && leftMinDepth != 1)
			return leftMinDepth;
		else if ((leftMinDepth == 1 || rightMinDepth <= leftMinDepth) && rightMinDepth != 1)
			return rightMinDepth;
		else
			return 0;
	}
	public int minimumDepthOfBinaryTree(TreeNode root)
	{
		return getMinDepthOfBinaryTree(root, 1);
	}
}
