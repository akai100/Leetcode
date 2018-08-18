package com.zxl.test.leetcode.exhaustive;

public class ExhaustiveSolution {

	private static double calck(Point p1, Point p2) {
		double deltaY = p2.y - p1.y;
		double deltaX = p2.x - p1.x;
		if (deltaX == 0)
			if (deltaY == 0)
				return Double.MIN_VALUE;
			else return Double.MAX_VALUE;
		return deltaY / deltaX;
	}
	/**
	 * ����һ���ά�㣬�ҵ���ͬһ��ֱ���ϵ�������Ŀ
	 * k00 k01 k02 k03
	 * k10 k11 k12 k13
	 * k20 k21 k22 k23
	 * k30 k31 k32 k33
	 * @param points
	 * @return
	 */
	public static int maxPoints(Point[] points)
	{
		if (points.length < 2) return 0;
		// �洢������֮���б��
		double[][] k = new double[points.length][points.length];
		int max = 0;
		for (int i = 0; i < points.length; i++)
		{
			for (int j = i + 1; j < points.length; j++) {
				double kIJ = calck(points[i], points[j]);
				k[i][j] = kIJ;
				k[j][i] = kIJ;
			}
				
		}
		for (int i = 0; i < points.length; i++)
		{
			for (int j = i + 1; j < points.length; j++)
			{
				if (k[i][j] == Double.MIN_VALUE) continue;
				int curNum = 0;
				for (int z = 0; z < points.length; z++)
				{
					if (z == i || z == j)
						continue;
					if (k[i][z] == k[i][j] || k[i][z] == Double.MIN_VALUE)
						curNum += 1;
				}
				if (max == 0 || curNum > max)
					max = curNum;
			}
		}
		return max + 2;
	}
}
