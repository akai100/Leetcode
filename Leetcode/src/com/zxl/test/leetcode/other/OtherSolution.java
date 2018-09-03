package com.zxl.test.leetcode.other;

import java.util.HashMap;

public class OtherSolution {

	public double myPow(double x, int n){
		if(n == 0)
			return 1;
		if(n < 0) {
			n = -n;
			x = 1/x;
		}
		return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
	}
	public int getNthUglyNummer(int n){
		int num = 1;
		do {
			if(isUglyNumber(num))  n--;
			num++;
		}while(n > 0);
		return --num;
	}
	private boolean isUglyNumber(int n){
		while(true) {
			if(n % 2 == 0) {
				n /= 2;
			}else if (n % 3 == 0){
				n /= 3;
			} else if(n % 5 == 0) {
				n /= 5;
			} else {
				break;
			}
		}
		if(n == 1) return true; 
		return false;
	}
	/**
	 * 不使用乘、除、取余运算实现两个整数的相除
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor){
		if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
			return Integer.MAX_VALUE;
		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
		long dvd = Math.abs((long) dividend);
		long dvs = Math.abs((long) divisor);
		int res = 0;
		while(dvd >= dvs){
			long tmp = dvs, multiple = 1;
			while(dvd >= (tmp << 1)) {
				tmp <<= 1;
				multiple <<= 1;
			}
			dvd -= tmp;
			res += multiple;
		}
		return sign == 1 ? res : -res;
	}
	public int romanToInt(String s) {
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for(int i = 0; i < s.length(); i++){
			if(i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
				ans += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
				i++;
			}else{
				ans += map.get(s.charAt(i));
			}
		}
		return ans;
	}
	/**
	 * 将整数转化成罗马字符
	 * @param num
	 * @return
	 */
	public String intToRoman(int num){
		String M[] = {"", "M", "MM", "MMM"};
		String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
	}
	public int reverse(int x) {
		int i = x < 0 ? -1 : 1, r = 0;
		x *= i;
		while(x != 0) {
			long tmp = ((long) r) * 10 + x % 10;
			if (tmp > Integer.MAX_VALUE) return 0;
			r = r * 10 + x % 10;
			x = x / 10;
		}
		return i * r;
	}
	/**
	 * 生成一个回环矩阵
	 *    
	 *  2 1 6
	 *  3 4 5
	 * @param n
	 * @return
	 */
	public static int[][] makeQueueRect(int n){

		int[][] result = new int[n][n];
		int startRowIndex  = n / 2, startColIndex = startRowIndex, value = 1;
		result[startRowIndex][startColIndex] = 1;

		makeQueueRectHelper(result, startRowIndex, startColIndex - 1, 2);
		return result;
	}
	/**
	 * d:0-down,1-right,2-up,3left;
	 * @param result
	 * @param startRowIndex
	 * @param startColumnIndex
	 * @param startValue
	 */
	public static void makeQueueRectHelper(int[][] result, int startRowIndex, int startColumnIndex, int startValue) {
		if(startRowIndex < 0 || startRowIndex >= result.length || 
				startColumnIndex < 0 || startColumnIndex >= result[0].length)
			return;
		int rowIndex = startRowIndex, colIndex = startColumnIndex, value = startValue, d = 0;
		do{
			result[rowIndex][colIndex] = value;
			switch (d) {
			case 0:
				if(rowIndex + 1 >= result.length - startColumnIndex){
					d = 1;
					colIndex++;
				} else{
					rowIndex ++;
				}
				value++;
				break;
			case 1:
				if(colIndex + 1 >= result[0].length - startColumnIndex){
					d = 2;
					rowIndex--;
				}else{
					colIndex++;
				}
				value++;
				break;
			case 2:
				if(rowIndex - 1 < startRowIndex - 1) {
					d = 3;
					colIndex--;
				} else{
					rowIndex--;
				}
				value++;
				break;
			case 3:
				if(colIndex - 1 < startColumnIndex) {
					d = 0;
					rowIndex ++;
				} else{
					colIndex--;
				}
				value++;
				break;
			default:
				break;
			}
		} while(rowIndex != startRowIndex || colIndex != startColumnIndex);
		makeQueueRectHelper(result, startRowIndex - 1, startColumnIndex - 1, value);
	}

	public static void other_solution_test() {
		System.out.println("------------------OtherSolution test------------------");
		OtherSolution solution = new OtherSolution();
		System.out.println("(1)test reverse...");
		System.out.println(solution.reverse(1534236469));
		System.out.println("test intToRoman...");
		System.out.println("3's roman: " + solution.intToRoman(3));
		System.out.println("4's roman: " + solution.intToRoman(4));
		System.out.println("9's roman: " + solution.intToRoman(9));
		System.out.println("58's roman: " + solution.intToRoman(58));
		System.out.println("1994's roman: " + solution.intToRoman(1994));
		
		System.out.println("test romanToInt...");
		System.out.println(solution.romanToInt("III"));
		System.out.println(solution.romanToInt("IV"));
		System.out.println(solution.romanToInt("IX"));
		System.out.println(solution.romanToInt("LVIII"));
		
		solution.testDivide();
		
		solution.testGetNthUglyNumber();
		
		solution.testMyPow();
	}
	
	public void testDivide(){
		System.out.println("test divide...");
		System.out.println(divide(-2147483648, 2));
	}
	
	public void testGetNthUglyNumber(){
		System.out.println("test ...getNthUglyNummer");
		System.out.println(getNthUglyNummer(7));
	}
	
	public void testMyPow(){
		System.out.println("test MyPow...");
		System.out.println(myPow(2.00000, 10));
		System.out.println(myPow(2.10000, 3));
		System.out.println(myPow(0.00001, 2147483647));
	}
}
