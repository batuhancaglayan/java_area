package com.algorithm.tryer.util;

public final class StringUtil {

	public static String reverse(String str) {
		if (str == null) {
			return null;
		}

		int strLength = str.length();
		if (strLength < 2) {
			return str;
		}

		char strChrArr[] = str.toCharArray();
		char temp;
		for (int i = 0; i < strLength / 2; i++) {
			temp = strChrArr[i];
			strChrArr[i] = strChrArr[strLength - 1 - i];
			strChrArr[strLength - 1 - i] = temp;
		}

		return String.valueOf(strChrArr);
	}
}
