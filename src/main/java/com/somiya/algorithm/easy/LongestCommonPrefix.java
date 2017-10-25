package com.somiya.algorithm.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
		    return "";
		}
		String s = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while(!strs[i].startsWith(s)) {
				s = s.substring(0, s.length() - 1);
			}
		}

		return s;
	}

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"abca","abc"}));
	}
}
