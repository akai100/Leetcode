package com.zxl.test.leetcode.complexity;

import java.util.HashMap;

public class ComplexitySolution {

	/**
	 * 给定一个整数数组，除了一个元素外，每个元素都会出现三次, 找到那一个。
	 * @param A
	 * @return
	 */
	public static int singleNumber(int[] A)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : A){
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}
		for(int key : map.keySet()){
			if(map.get(key) != 3)
				return key;
		}
		return 0;
	}
	
	/**
	 * 给定一个整数数组，除了一个元素外，每个元素都会出现两次。 找到那一个。
	 * 您的算法应具有线性运行时复杂性。 你能不用额外的内存来实现吗？
	 * @param A
	 * @return
	 */
	public static int singleNumber2(int[] A){
		int result = A[0];
		for(int i = 1; i < A.length; i++){
			result ^= A[i];
		}
		return result;
	}
	
}
