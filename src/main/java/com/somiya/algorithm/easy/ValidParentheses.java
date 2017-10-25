package com.somiya.algorithm.easy;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public static boolean isValid(String s) {
		int len = s.length();
		if (len % 2 == 1) {
		    return false;
		}
		char[] stack = new char[len];

			int p = 0;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack[p++] = c;
			} else {
				if (p <= 0) {
				    return false;
				}
				if (c == '}') {
				    if (stack[--p] != '{') {
						return false;
				    }
				} else if (c == ')') {
				    if (stack[--p] != '(') {
				        return false;
				    }
				} else if (c == ']') {
				    if (stack[--p] != '[') {
				        return false;
				    }
				} else {
					return false;
				}
			}
		}
		if (p > 0) {
			return false;
		}
		return true;
		//List<Character> stack = new ArrayList<>();
		//for (int i = 0; i < s.length(); i++) {
		//	char c = s.charAt(i);
		//	if (stack.size() == 0) {
		//	    stack.add(c);
		//	    continue;
		//	}
		//	char l = stack.get(stack.size() - 1);
		//	if ((l == "{".charAt(0) && c == "}".charAt(0)) || (l == "(".charAt(0) && c == ")".charAt(0)) || (l == "[".charAt(0) && c == "]".charAt(0))) {
		//	    stack.remove(stack.size() - 1);
		//	} else {
		//		stack.add(c);
		//	}
		//}
		//return stack.size() == 0 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(isValid("{{}}(({})[{}])"));
	}
}
