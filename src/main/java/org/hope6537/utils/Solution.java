package org.hope6537.utils;

import org.junit.Test;

public class Solution {
	public int atoi(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			int pow = (int) (Math.pow(10, str.length() - i - 1));
			int now = str.charAt(i) - 48;
			result += pow * now;
		}
		return result;
	}

	@Test
	public void test() {
		int a = this.atoi("123456");
		System.out.println(a);
	}
}