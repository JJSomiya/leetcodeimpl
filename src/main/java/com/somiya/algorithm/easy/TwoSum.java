package com.somiya.algorithm.easy;

import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * 	Given <code>nums = [2, 7, 11, 15]</code>, <code>target = 9</code>,
 *  Because <code>nums[0] + nums[1] = 2 + 7 = 9</code>,
 *  <code>return [0, 1]</code>.
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		/**
		 * 	复杂度分析
		 * 	时间复杂度：共进行 (n * (n - 1)) / 2  故为：O(n^2)
		 * 	空间复杂度：O(n)
		 */
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((nums[i] + nums[j]) == target) {
				    return new int[]{i, j};
				}
			}
		}
		return new int[]{};
	}

	public static void main(String[] args) {
		// 生成随机整数数组(100以内)
		Random random = new Random();

		Set<Integer> numsSet = new HashSet<>();
		int i = 0;
		while(i < 20) {
			int next = random.nextInt(50);
			numsSet.add(next);
			i++;
		}
		int[] nums = new int[numsSet.size()];
		nums = numsSet.stream().mapToInt(x -> x).toArray();
		System.out.print("原始数组：");
		numsSet.stream().map(x -> x + " ").forEach(System.out::print);
		System.out.println();
		int target = random.nextInt(50);
		System.out.println("target：" + target);
		int[] ret = twoSum(nums, target);
		System.out.print("结果：");
		for (int i1 : ret) {
			System.out.println(i1 + " : " + nums[i1]);
		}
		System.out.println();
	}
}
