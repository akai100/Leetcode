package com.zxl.test.leetcode.complexity;

import java.util.HashMap;

public class ComplexitySolution {

	/**
	 * ����һ���������飬����һ��Ԫ���⣬ÿ��Ԫ�ض����������, �ҵ���һ����
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
	 * ����һ���������飬����һ��Ԫ���⣬ÿ��Ԫ�ض���������Ρ� �ҵ���һ����
	 * �����㷨Ӧ������������ʱ�����ԡ� ���ܲ��ö�����ڴ���ʵ����
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
