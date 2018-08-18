package com.zxl.test.leetcode.hash;

import java.util.HashMap;

public class HashSolution {

	/**
	 * 给定一个整数数组，找到两个数字，使它们合计到一个特定的目标数字。函数twoSum应该返回这两个数字的
	 * 索引，使它们合计成目标，其中index1必须小于index2。 请注意，您返回的答案（index1和index2）
	 * 不是基于零的。您可能会认为每个输入只能有一个解决方案。
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
