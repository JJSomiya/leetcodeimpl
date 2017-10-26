package com.somiya.algorithm.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		System.out.println(Arrays.toString(nums));
		if (nums.length < 2) {
			return nums.length;
		}

		int j = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j - 1]) {
				nums[j++] = nums[i];
			}
		}
		System.out.println(Arrays.toString(nums));
		return j;
		//if (nums.length < 2) {
		//    return nums.length;
		//}
		//int i = 0;
		//int last = nums[nums.length - 1];
		//for (; i < nums.length - 1;) {
		//	int j = i + 1;
		//	if (nums[i] == nums[j]) {
		//		if (nums[i] == last) {
		//		    break;
		//		}
		//		for (; j < nums.length; j++) {
		//			nums[j - 1] = nums[j];
		//		}
		//	} else {
		//		i++;
		//	}
		//}
		//return i + 1;
	}

	public static void main(String[] args) {
		Random random = new Random();
		int times = 30;
		boolean isOk = true;
		while(times > 0) {
			times--;
			int len = random.nextInt(15);
			int[] nums = new int[len];
			for (int i = 0; i < len; i++) {
				nums[i] = random.nextInt(7);
			}
			Arrays.sort(nums);
			Set<Integer> numObj = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {
				numObj.add(nums[i]);
			}
			if (numObj.size() != removeDuplicates(nums)) {
				isOk = false;
				System.out.println(Arrays.toString(nums));
				break;
			}
		}
		if (isOk) {
			System.out.println("OK！！！！！！！！！");
		} else {
			System.out.println("出错！！！！！！！！");
		}
	}
}
