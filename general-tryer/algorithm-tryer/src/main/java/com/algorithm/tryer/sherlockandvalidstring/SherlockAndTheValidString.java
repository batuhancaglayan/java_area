package com.algorithm.tryer.sherlockandvalidstring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class SherlockAndTheValidString {

	private static int ALPHABET_CNT = 26;

	public static String isValid(String s) {

		char[] sChrArr = new char[ALPHABET_CNT];
		for (int i = 0; i < s.length(); i++) {
			int a = s.charAt(i) - 97;
			sChrArr[s.charAt(i) - 97] += 1;
		}

		int incompatibleChrCount = 0;
		int incompatibleChrIndex = 0;
		int tempChr = -1;
		for (int i = 0; i < ALPHABET_CNT; i++) {
			if ((int) sChrArr[i] == 0) {
				continue;
			}

			if (tempChr == -1) {
				tempChr = sChrArr[i];
				continue;
			}

			if (incompatibleChrCount > 1) {
				break;
			}

			if (tempChr != (int) sChrArr[i]) {
				incompatibleChrCount++;
				incompatibleChrIndex = i;
			}
		}

		if (incompatibleChrCount > 1) {
			return "NO";
		}
		
		if ((int) sChrArr[incompatibleChrIndex] == 1) {
			return "NO";
		}
		
		return "YES";
		
		//return incompatibleChrCount <= 1 ? "YES" : (int) sChrArr[incompatibleChrIndex] == 1 ? "YES" : "NO";
	}
}
