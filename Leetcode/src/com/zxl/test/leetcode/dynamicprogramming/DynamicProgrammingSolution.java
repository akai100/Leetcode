package com.zxl.test.leetcode.dynamicprogramming;

import java.util.ArrayList;
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
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = wordBreakHelper(s, dict);
		int i = result.size() - 1;
		for(; i > 0; i--){
			for(int j = i - 1; j >=0; j--) {
				if(result.get(i).equals(result.get(j))){
					result.remove(i);
					break;
				}
			}
		}
		return result;
	}
	
	public static ArrayList<String> wordBreakHelper(String s,Set<String> dict){
		ArrayList<String> result = new ArrayList<String>();
		if(s.length() == 1){
			for(String str : dict)
				if(s == str){
					result.add(s);
				}
			return result;
		}
		for (int i = 1; i < s.length(); i++)
		{
			String leftStr = s.substring(0, i);
			String rightStr = s.substring(i, s.length());
			ArrayList<String> leftSplits =  wordBreak(leftStr, dict);
			ArrayList<String> rightSplits = wordBreak(rightStr, dict);
			if (leftSplits.size() > 0 && rightSplits.size() > 0) {
				for(int k = 0; k < leftSplits.size(); k++) {
					for(int j = 0; j < rightSplits.size(); j++){
						result.add(leftSplits.get(k) + " " + rightSplits.get(j));
					}
				}
			}
			if(strInDict(leftStr, dict)) {
				for(int k = 0; k < rightSplits.size(); k ++)
					result.add(leftStr + " " + rightSplits.get(k));
			}
			if(strInDict(rightStr, dict))
				for(int k = 0; k < leftSplits.size(); k++)
					result.add(leftSplits.get(k) + " " + rightStr);
			if(strInDict(leftStr, dict) && strInDict(rightStr, dict))
				result.add(leftStr + " " + rightStr);
		}
		return result;
	}
	
	public static boolean strInDict(String str, Set<String> dict) {
		for(String tmp : dict){
			if(str.equals(tmp))
				return true;
		}
		return false;
	}
	/**
	 * 有N个孩子排队。 每个孩子都被赋予一个评定值。你给这些孩子的糖果按照以下要求：每个孩子必须
	 * 至少有一颗糖果。评分较高的孩子得到的糖果比他们的邻居多。什么是你必须给的最低糖果？
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		int result = ratings.length;
		for(int i = 0;i < ratings.length;)break;
		return 0;
	}
	
	public static int minCut(String s) {
		ArrayList<String> strings = new ArrayList<String>(); 
		return 0;
	}
	
	public static int minCutHelper(String s) {
		if(isPalindrome(s)) return 0;
		for(int i = 0; i < s.length(); i++){
			String a = s.substring(0, i);
			String b = s.substring(i, s.length());
		}
		return 0;
	}
	
	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}
