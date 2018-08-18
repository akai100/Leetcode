package com.zxl.test.leetcode.string;

public class StringSolution {

	/**
	 * ����һ���ַ������ҵ�û���ظ��ַ�����ִ��ĳ���
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
	 * ����һ���ַ���S���ҵ�S����Ļ������ַ���������Լ���S����󳤶���1000�����Ҵ���һ��Ψһ
	 * ��Ļ������ַ�����
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
