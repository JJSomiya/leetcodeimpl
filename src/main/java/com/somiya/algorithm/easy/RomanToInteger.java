package com.somiya.algorithm.easy;

import org.w3c.dom.ls.LSException;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	// Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）
	// 符号 I、X 或 C 位于大数的后面时就作为加数；位于大数的前面就作为减数
	public static int romanToInt(String s) {
		Map<String, Integer> R2I = new HashMap(){{
			put("I", 1);
			put("V", 5);
			put("X", 10);
			put("L", 50);
			put("C", 100);
			put("D", 500);
			put("M", 1000);
		}};
		String ss = "IXC";
		int num = 0;
		int i = 0;
		while(i < s.length()) {
			String current = s.charAt(i) + "";
			if (i < s.length() - 1) {
				String next = s.charAt(i + 1) + "";
				if (ss.contains(current) && R2I.get(current) < R2I.get(next)) {
					num -= R2I.get(current);
				} else {
					num += R2I.get(current);
				}
			} else {
				num += R2I.get(current);
			}
			i++;
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MMMCMXCIX"));
	}
}
