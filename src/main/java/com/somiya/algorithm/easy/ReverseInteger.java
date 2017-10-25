package com.somiya.algorithm.easy;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <strong>Note:</strong>
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
	public static int reverse(int x) {
		int[] nums;
		int len = 0;
		if (x > 0) {
			len = (x + "").length();
		} else {
			len = (x + "").length() - 1;
		}
		int absx = Math.abs(x);
		long reverseX = 0;
		for (int i = len - 1; i >= 0; i--) {
			int divisor = (int) Math.pow(10, i);
			int quotient = absx / divisor;
			absx -= divisor * quotient;
			reverseX += quotient * (long) Math.pow(10, len - 1 - i);
		}
		if (x < 0) {
			reverseX = reverseX * -1;
		}

		if (reverseX > Integer.MAX_VALUE || reverseX < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) reverseX;
	}

	public static void main(String[] args) {
		System.out.println(reverse(1234));
		System.out.println(Integer.MIN_VALUE);
	}
}
