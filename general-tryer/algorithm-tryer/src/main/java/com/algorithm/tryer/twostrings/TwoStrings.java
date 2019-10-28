package com.algorithm.tryer.twostrings;

import java.util.HashSet;
import java.util.Set;

public final class TwoStrings {

	public static String twoStrings(String s1, String s2) {
		boolean result = false;

		Set<Character> unique = new HashSet<Character>();
		for (char c : s1.toCharArray()) {
			if (!unique.contains(c)) {
				unique.add(c);
			}
		}

		for (char c : s2.toCharArray()) {
			if (unique.contains(c)) {
				result = true;
				break;
			}
		}

		return result ? "YES" : "NO";
	}
}
