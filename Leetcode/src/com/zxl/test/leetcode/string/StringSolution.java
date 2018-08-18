package com.zxl.test.leetcode.string;

public class StringSolution {

	/**
	 * 给定一个字符串，找到没有重复字符的最长字串的长度
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = i + 1; j < s.length(); j++)
			{
				if (s.charAt(i) == s.charAt(j))
				{
					int leftMaxLength = lengthOfLongestSubstring(s.substring(0, j));
					int rightMaxLength = lengthOfLongestSubstring(s.substring(i+ 1, s.length()));
					if (leftMaxLength > rightMaxLength)
						return leftMaxLength;
					else
						return rightMaxLength;
				}
			}
		}
		return s.length();
	}
	
	/**
	 * 给定一个字符串S，找到S中最长的回文子字符串。你可以假设S的最大长度是1000，并且存在一个唯一
	 * 最长的回文子字符串。
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s)
	{
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--)
		{
			if (s.charAt(i) != s.charAt(j))
			{
				String leftString = longestPalindrome(s.substring(0, j));
				String righString = longestPalindrome(s.substring(i + 1, s.length()));
				if (leftString.length() > righString.length())
					return leftString;
				else
					return righString;
			}
				
		}
		return s;
	}
}
