package com.somiya.algorithm.easy;

import java.util.*;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		if (nums.length < 1) {
			return 0;
		}
		if (nums.length < 2) {
		    if (nums[0] == val) {
		        return 0;
		    } else {
		    	return 1;
			}
		}
		int j = nums.length - 1;
		int i = 0;
		do {
			if (nums[i] != val) {
				i++;
			} else {
				if (nums[j] == val) {
				    j--;
				} else {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					j--;
					i++;
				}
			}
		}while(i <= j);
		return i;
	}

	public static void main(String[] args) {
		Random random = new Random();
		int times = 30000;
		boolean isOk = true;
		while(times > 0) {
			times--;
			int len = random.nextInt(150);
			int[] nums = new int[len];
			for (int i = 0; i < len; i++) {
				nums[i] = random.nextInt(7);
			}
			List<Integer> l = new ArrayList<>();
			int val = random.nextInt(7);
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != val) {
				    l.add(nums[i]);
				}
			}

			if (l.size() != removeElement(nums, val)) {
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
