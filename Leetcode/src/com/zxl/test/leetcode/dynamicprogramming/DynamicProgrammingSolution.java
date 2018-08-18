package com.zxl.test.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DynamicProgrammingSolution {

	/**
	 * 给定一个字符串s和单词字典dict，构造一个句子每个单词都是在词典中
	 * 出现过，返回所有可能的句子
	 * 例如：s = "catsanddog"
	 * dict = ["cat", "cats", "and", "sand", "dog"]
	 * return ["cats and dog", "cat sand dog"]
	 * @param s
	 * @param dict
	 * @return
	 */
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 1; i < s.length(); i++)
		{
			String str = s.substring(i);
			for (int j = 1; j < dict.size(); j++)
			{
			}
		}
		return null;
	}
	
	/**
	 * 有N个孩子排队。 每个孩子都被赋予一个评定值。你给这些孩子的糖果按照以下要求：每个孩子必须
	 * 至少有一颗糖果。评分较高的孩子得到的糖果比他们的邻居多。什么是你必须给的最低糖果？
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		return 0;
	}
}
