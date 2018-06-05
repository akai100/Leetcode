package com.zxl.test.leetcode.exhaustive;

public class ExhaustiveSolution {

	/**
	 * 给定一组二维点，找到在同一条直线上的最多点数目
	 * @param points
	 * @return
	 */
	public int maxPoints(Point[] points)
	{
		// 存储两个点之间的斜率
		double[][] k = new double[points.length][points.length];
		int max = 0;
		for (int i = 0; i < points.length; i++)
		{
			for (int j = i + 1; j < points.length; j++)
				if ((points[j].x - points[i].x) == 0)
                    if ((points[j].y - points[i].y) == 0)
                        k[i][j] = Double.NEGATIVE_INFINITY;
                    else
                        k[i][j] = Double.POSITIVE_INFINITY;
                else
                    k[i][j] = ((double) (points[j].y - points[i].y)) / (points[j].x - points[i].x);
		}
		for (int i = 0; i < points.length; i++)
		{
			for (int j = i + 1; j < points.length; j++)
			{
				int curNum = 0;
				for (int z = 0; z < points.length; z++)
				{
					if (z == i || z == j)
						continue;
					if (k[i][z] == k[i][j])
						curNum += 1;
				}
				if (max == 0 || curNum > max)
					max = curNum;
			}
		}
		return max + 2;
	}
}
