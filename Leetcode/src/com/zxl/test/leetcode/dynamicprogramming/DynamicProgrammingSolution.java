package com.zxl.test.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DynamicProgrammingSolution {

	/**
	 * ����һ���ַ���s�͵����ֵ�dict������һ������ÿ�����ʶ����ڴʵ���
	 * ���ֹ����������п��ܵľ���
	 * ���磺s = "catsanddog"
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
	 * ��N�������Ŷӡ� ÿ�����Ӷ�������һ������ֵ�������Щ���ӵ��ǹ���������Ҫ��ÿ�����ӱ���
	 * ������һ���ǹ������ֽϸߵĺ��ӵõ����ǹ������ǵ��ھӶࡣʲô��������������ǹ���
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		return 0;
	}
}
