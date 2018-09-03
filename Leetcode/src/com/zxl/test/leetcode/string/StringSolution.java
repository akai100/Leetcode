package com.zxl.test.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;



public class StringSolution {

	public List<List<String>> groupAnagrams(String[] strs) {
		return null;
	}
	public int longestValidParenteses(String s){
		return 0;
	}
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public int solve(String str1, String str2) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c1 : str1.toCharArray()){
			map.put(c1, 1);
		}
		return 0;
	}
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<Integer>();
		int[] a = new int[words.length];
		for(int i = 0; i < words.length; i++){
		}
		return ans;
	}
	public List<String> generateParenthesis(int n){
		List<String> ans = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		stack.push("(");
		List<String> list = generateParenthesisHelper((Stack<String>) stack.clone(), "(", n, 1, 0);
		List<String> list2 = generateParenthesisHelper(stack, ")", n, 1, 0);
		for(String s : list){
			ans.add("(" + s);
		}
		for(String s : list2){
			ans.add("(" + s);
		}
		return ans;
	}
	/**
	 * 
	 * @param n
	 * @param n1-前半部分(数量
	 * @param n2-前半部分)数量
	 * @param n3：后半部分(数量
	 * @param n4：后半部分)数量
	 * @return
	 */
	private List<String> generateParenthesisHelper(Stack<String> stack, String str, int n, int n1, int n2){
		List<String> list = new ArrayList<String>();
		if (str.equals("(") && n1 < n) {
			stack.push(str);
			n1 += 1;
		}
		else if(str.equals(")") && stack.size() > 0 &&n2 < n &&stack.peek().equals("(")) {
			stack.pop();
			n2 += 1;
		}else{
			return list;
		}
		if (n1 == n && n2 == n && stack.size() == 0){
			list.add(str);
			return list;
		}
		List<String> tmpList = generateParenthesisHelper((Stack<String>) stack.clone(), "(", n, n1, n2);
		for(String s : tmpList){
			list.add(str + s);
		}
		List<String> tmpList2 = generateParenthesisHelper((Stack<String>) stack.clone(), ")", n, n1, n2);
		for(String s: tmpList2){
			list.add(str + s);
		}
		return list;
	}
	HashMap<Character, String> map;
	public StringSolution(){
		map = new HashMap<Character, String>();
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		boolean ans = true;
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(c == '(' || c == '{' || c == '['){
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if(stack.size() <= 0 || (c == ')' && stack.pop() != '(')||
						(c == '}' && stack.pop() != '{')|| (c == ']' && stack.pop() != '[')){
					ans = false;
					break;
				} 
			}
		}
		if(ans && stack.size() > 0) ans = false;
		return ans;
	}
	
	/**
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<String>();
		if (digits.equals("")) return ans;
		char c = digits.charAt(0);
		String str = map.get(c);
		if(digits.length() == 1) {
			for(char t : str.toCharArray()){
				ans.add( "" + t);
			}
			return ans;
		}
		List<String> list = letterCombinations(digits.substring(1, digits.length()));
		for(char t : str.toCharArray()){
			for(String s : list){
				ans.add(t + s);
			}
		}
		return ans;
	}
	public String longestCommonPrefix(String [] strs){
		if(strs.length < 1) return "";
		String ans = "";
		int i = 0;
		while(true) {
			if(i > strs[0].length() - 1) break;
			char tmp = strs[0].charAt(i);
			boolean isBreak = false;
			for(String str : strs){
				if(i > str.length() - 1 || str.charAt(i) != tmp){
					isBreak = true;
					break;
				}
			}
			if(isBreak) break;
			ans += tmp;
			i++;
		}
		return ans;
	}
	public boolean isMathch(String s, String p){
		if (s.equals(p)) return true;
		int i = 0;
		while(s.charAt(i) == s.charAt(i)){
			i++;
		}
		if(p.charAt(i) != '*' || p.charAt(i) != '.') return false;
		if(p.charAt(i) == '.') {

		}
		return true;
	}
	public int myAtoi(String str) {
		int ans = 0;
		int sign = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if (c == ' ')
				continue;
			if(c <= '9' && c >= '0'){
				sign = (sign == 0 ? 1 : sign);
				long t = ans * 10 + sign * (c - '0');
				if ( t < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				if (t > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				ans = ans * 10 + sign * (c - '0');

			}else if (ans == 0 && sign == 0&& (c == '+' || c == '-')){
				sign = (c == '-' ? -1 : 1);
			} else{
				return ans;
			}
		}
		return ans;
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;
		String ans = "";
		int k = 2 * numRows - 2, a = s.length() / k + 1;
		for(int i = 0; i < numRows; i ++) {
			for(int j = 0; j < a; j++){
				if(k * j + i > s.length() - 1) break;
				ans += s.charAt(k * j + i);
				if((k  * j + k - i) > (s.length() - 1)) break;
				if(i != 0 && i != numRows - 1){
					ans += s.charAt(k  * j + k - i);
				}
			}
		}
		return ans;
	}
	/**
	 * 给定一个字符串，找到没有重复字符的最长字串的长度
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s)
	{
		int n = s.length(), ans = 0;
		int[] index = new int[128];
		for(int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring2(String s){
		if(s.equals("")) return 0;
		int i = 0, j = 1, ans = 0;
		while(j < s.length()){
			int k = i;
			for(; k < j; k++) {
				if(s.charAt(k) == s.charAt(j)) break;
			}
			if(k != j){
				ans = Math.max(ans, j - i);
				i = k + 1;
			}
			j++;
		}
		return Math.max(ans, j - i);

	}
	/**
	 * 给定一个字符串S，找到S中最长的回文子字符串。你可以假设S的最大长度是1000，并且存在一个唯一
	 * 最长的回文子字符串。
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s)
	{
		String ans = "";
		int n = s.length();
		for(int i = 0; i < n; i++){

		}
		return null;  
	}
	private int expandAroundCenter(String s, int left, int right){
		int L = left, R = right;
		while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

	public static void test(){
		System.out.println("-----------------StringSolution test-----------------");
		StringSolution solution = new StringSolution();
		System.out.println("(1) test MyAtoi...");
		System.out.println(solution.myAtoi("  +-42")); 
		System.out.println("test longestCommonPrefix...");
		String[] testStrs = {
				"flower","flow","flight"
		};
		System.out.println(solution.longestCommonPrefix(testStrs));
		System.out.println("test letterCombinations");
		List<String> ans = solution.letterCombinations("23");
		for(String str : ans) System.out.print(str + " ");
		System.out.println();
		System.out.println("test ");
		System.out.println("() is valid:" + solution.isValid("()"));
		System.out.println("()[]{} is valid:" + solution.isValid("()[]{}"));
		System.out.println("(] is valid:" + solution.isValid("(]"));
		System.out.println("([)] is valid:" + solution.isValid("([)]"));
		System.out.println("{[]} is valid:" + solution.isValid("{[]}"));
		System.out.println();
		System.out.println("test generateParenthesis...");
		List<String> list = solution.generateParenthesis(3);
		for(String s : list)
			System.out.print(s + " ");
		System.out.println();
	}
}
