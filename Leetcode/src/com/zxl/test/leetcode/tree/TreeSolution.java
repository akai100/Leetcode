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
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		return hasPathSumHelper(root, sum, 0);
	}
	
	public static boolean hasPathSumHelper(TreeNode node, int sum, int preSum) {
		System.out.println(node.val);
		int curSum = (preSum + node.val);
		if(node.left == null && node.right == null) {  // 叶子节点
			if(curSum == sum)
				return true;
			else
				return false;
		}
		else { // 当前为非叶子节点
			boolean leftResult = false;
			if (node.left != null) {  // 左叶子结点非空
				leftResult = hasPathSumHelper(node.left, sum, curSum);
			}
			if(leftResult) return leftResult;
			if(node.right != null)
				return hasPathSumHelper(node.right, sum, curSum);
			return false;
		}
	}
	
	public static boolean isBalanced(TreeNode root){
		if(root == null) return true;
		return (isBalancedHelper(root) != -1);
	}
	
	public static int nodeDepth(TreeNode node) {
		if(node == null) return 0;
		int leftDepth = nodeDepth(node.left);
		int rightDepth = nodeDepth(node.right);
		return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}
	
	public static int isBalancedHelper(TreeNode node){
		if(node == null) return 0;
		int leftHeight = isBalancedHelper(node.left);
		if(leftHeight == -1) return -1;
		int rightHeight = isBalancedHelper(node.right);
		if(rightHeight ==-1) return -1;
		if (Math.abs(rightHeight - leftHeight) <= 1)
			return (rightHeight > leftHeight ? rightHeight + 1 : leftHeight + 1);
		return -1;
	}
	
	public static int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		return sumNumbersHelper(root, 0);
	}
	
	public static int sumNumbersHelper(TreeNode root, int preNum) {
		if(root.left == null && root.right == null) return preNum*10 + root.val;
		int sum = 0;
		if(root.left != null) sum += sumNumbersHelper(root.left, preNum * 10 + root.val);
		if(root.right != null) sum += sumNumbersHelper(root.right, preNum * 10 + root.val);
		return sum;
		
	}
}
