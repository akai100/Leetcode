package com.zxl.test.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ArraySolution {

	public int jump(int[] nums){
		if(nums.length <= 1) return 0;
		int[] minPath = new int[nums.length - 1];
		for(int i = minPath.length - 1; i >= 0; i--) {
			if(nums[i] >= nums.length - 1 - i) {
				minPath[i] = 1;
				continue;
			}
			int path = 1, min = Integer.MAX_VALUE;
			while(path <= nums[i] && i + path <= nums.length - 1){
				if(minPath[i + path] != Integer.MAX_VALUE)
					if(1 + minPath[i + path] < min) min = 1 + minPath[i + path];
				path++;
			}
			minPath[i] = min;
		}
		return minPath[0];
	}
	public List<List<Integer>> permuteUnique(int[] nums){
		return null;
	}
	public List<List<Integer>> permute(int[] nums){
		HashSet<Integer> set = new HashSet<Integer>();
		return permuteHelper(nums, set);
	}
	private List<List<Integer>> permuteHelper(int[] nums, HashSet<Integer> set){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length; i++){
			if(!set.contains(i)){
				HashSet<Integer> tmpSet = (HashSet<Integer>) set.clone();
				tmpSet.add(i);
				List<List<Integer>> tmp = permuteHelper(nums, tmpSet);
				
				for(List<Integer> t : tmp) {
					ArrayList<Integer> t1 = new ArrayList<Integer>();
					t1.add(nums[i]);
					t1.addAll(t);
					list.add(t1);
				}
				if(tmp.size() == 0){
					ArrayList<Integer> t1 = new ArrayList<Integer>();
					t1.add(nums[i]);
					list.add(t1);
				}
			}
		}
		return list;
	}
	public void rotate(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = i + 1; j < matrix[0].length; j++){
				int tmp = matrix[i][j];;
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		int i = 0, j = matrix.length - 1;
		while(i < j){
			for(int k = 0; k < matrix.length; k++){
				int tmp = matrix[k][i];
				matrix[k][i] = matrix[k][j];
				matrix[k][j] = tmp;
			}
			i++;
			j--;
		}
	}
	private int[] get_next(String str){
		int n = str.length();
		int[] next = new int[n];
		next[0] = -1;
		int k = -1;
		for(int q = 1; q <= n - 1; q++){
			while(k > -1 && str.charAt(k + 1) != str.charAt(q)){
				k = next[k];
			}
			if(str.charAt(k + 1) == str.charAt(q)) k = k + 1;
			next[q] = k;
		}
		return next;
	}
	public int strStr(String haystack, String needle) {
		if(needle.equals("")) return 0;
		
		int[] next = get_next(needle);
		int k = -1;
		for(int i = 0; i < haystack.length(); i++){
			while(k > - 1 && needle.charAt(k + 1) != haystack.charAt(i))
				k = next[k];
			if (needle.charAt(k + 1) == haystack.charAt(i)) k +=1;
			if (k == needle.length() - 1) return i - needle.length() + 1;
		}
		return -1;
	}
	public int removeElement(int[] nums, int val) {
		int moveNum = 0; // 向前移动次数
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == val){
				moveNum++;
			}else{
				int tmp = 1;
				nums[i - moveNum] = nums[i];
			}
		}
		return nums.length - moveNum;
	}
	public int removeDuplicates(int[] nums){
		int ans = 0;
		for(int i = 0; i < nums.length; i++){
			if(i == 0 || nums[i] != nums[i - 1]){
				nums[ans] = nums[i];
				ans += 1;
			}
		}
		return ans;
	}
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int i = 0, ans = -1, t = 0;
		while(i < nums.length - 2) {
			int j = i + 1, k = nums.length - 1;
			while(j < k){
				int r = target - nums[i] - nums[j] -nums[k];
				if(ans == -1) {
					ans = Math.abs(r);
					t = nums[i] + nums[j] + nums[k];
				}
				else if(ans > Math.abs(r)) {
					ans = Math.min(ans, Math.abs(r));
					t = nums[i] + nums[j] + nums[k];
				}
				if(r > 0) j++;
				else k--;
			}
			i++;
		}
		return t;
	}
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length - 2;i++){
			if(i == 0 ||(i > 0 && nums[i] != nums[i - 1])){
				int lo = i + 1, hi = nums.length - 1, sum  = 0 - nums[i];
				while(lo < hi){
					if (nums[lo] + nums[hi] == sum) {
						result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
						while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
						lo++;hi--;
					} else if(nums[lo] + nums[hi] < sum) lo++;
					else hi--;
				}
			}
			return result;
		}
		return result;
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0, j = 0, medianIndex = (nums1.length + nums2.length) / 2 + 1, k = 0, v1 = 0, v2 = 0;
		while(k != medianIndex){
			v1 = v2;
			if(i < nums1.length && (j > nums2.length - 1 || nums1[i] < nums2[j])){
				v2 = nums1[i++];
			}else{
				v2 = nums2[j++];
			}
			k++;
		}
		if((nums1.length + nums2.length) % 2 == 0) return (v1 + v2) / 2.0;
		return v2;
	}


	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target){
		int []result = {-1, -1};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++){
			int r = target - nums[i];
			if(map.containsKey(r) && map.get(r) != i) {
				result[0] = i;
				result[1] = map.get(r);
				return result;
			}
		}
		return result;
	}
	public void solve(char[][] board){

	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public int longestConsecutive(int[] num) {
		return 0;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static  ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> preList = new ArrayList<String>();
		partitionHelper(result, preList, s);
		return result;
	}

	public static void partitionHelper(ArrayList<ArrayList<String>> result, ArrayList<String> preList, String s){
		for(int i = 1; i < s.length(); i++){
			String str = s.substring(0, i);
			if(isPalidrome(str)) {
				preList.add(str);
				partitionHelper(result, preList, s.substring(i, s.length()));
				result.add(preList);
			}
		}
	}

	/**
	 * 判断字符s是否为回文
	 * @param s
	 * @return
	 */
	private static boolean isPalidrome(String s) {
		int i = 0, j = s.length() - 1;
		while(i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void test(){
		System.out.println("--------------------ArraySolution Test--------------------");
		ArraySolution solution = new ArraySolution();
		System.out.println("test threeSumClosest...");
		System.out.println(solution.threeSumClosest(new int []{1,1,-1,-1,3}, 1));

		solution.testRemoveDuplicates();

		solution.testRemoveElement();
		
		solution.testStrStr();
		solution.testRotate();
		solution.testPermute();
		solution.testJump();
	}

	public void testRemoveDuplicates(){
		int[] nums = {1,1,2};
		System.out.println("test removeDuplicates...");
		System.out.println(removeDuplicates(nums));
		print(nums);
	}

	public void testRemoveElement(){
		System.out.println("test removeElement...");
		int[] nums = {3,2,2,3};
		System.out.println(removeElement(nums, 3));
		print(nums);
	}
	
	public void testStrStr(){
		System.out.println("test strStr...");
		String str1 = "hello";
		String str2 = "ll";
		System.out.println(strStr(str1, str2));
	
	}
	
	public void testRotate(){
		System.out.println("test rotate...");
		int[][] matrix = {
				{ 5, 1, 9,11},
				{ 2, 4, 8,10},
				{13, 3, 6, 7},
				{15,14,12,16},
		};
		rotate(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
	
	public void testPermute(){
		System.out.println("test permute...");
		int nums[] = {1, 2, 3};
		List<List<Integer>> lists = permute(nums);
		for(List<Integer> list : lists){
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	public void testJump(){
		System.out.println("test jump...");
		int[] nums = {2, 3, 0, 1, 4};
		System.out.println(jump(nums));
	}
	public void print(int[] arr){
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

}
