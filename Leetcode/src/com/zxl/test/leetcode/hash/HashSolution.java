package com.zxl.test.leetcode.hash;

import java.util.HashMap;

public class HashSolution {

	/**
	 * ����һ���������飬�ҵ��������֣�ʹ���ǺϼƵ�һ���ض���Ŀ�����֡�����twoSumӦ�÷������������ֵ�
	 * ������ʹ���ǺϼƳ�Ŀ�꣬����index1����С��index2�� ��ע�⣬�����صĴ𰸣�index1��index2��
	 * ���ǻ�����ġ������ܻ���Ϊÿ������ֻ����һ�����������
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		int result[] = new int[2];
		for (int i = 0; i < numbers.length; i++)
		{
			for (int j = i + 1; j < numbers.length; j++)
			{
				if (numbers[i] + numbers[j] == target)
				{
					result[0] = (numbers[i] < numbers[j])?i + 1:j + 1;
					result[1] = (numbers[i] > numbers[j])?i + 1:j + 1;
				}
			}
		}
		return result;
	}
}
