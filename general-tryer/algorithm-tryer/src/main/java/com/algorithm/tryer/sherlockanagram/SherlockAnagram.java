package com.algorithm.tryer.sherlockanagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SherlockAnagram {

	private static int ALPHABET_CNT = 26;

	public static int sherlockAndAnagrams(String s) {

		int anagramCount = 0;
		int sLength = s.length();
		List<String> subStringList = new ArrayList<>();
		for (int i = 0; i < sLength; i++) {
			for (int j = i + 1; j <= sLength; j++) {
				subStringList.add(s.substring(i, j));
			}
		}

		for (int i = 0; i < subStringList.size(); i++) {
			for (int j = i + 1; j < subStringList.size(); j++) {
				if (isAnagram(subStringList.get(i), subStringList.get(j))) {
					anagramCount++;
				}
			}
		}

		return anagramCount;
	}

	static boolean isAnagram(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		char[] s1ChrArr = new char[ALPHABET_CNT];
		char[] s2ChrArr = new char[ALPHABET_CNT];

		for (int i = 0; i < s1.length(); i++) {
			s1ChrArr[s1.charAt(i) - 97] += 1;
			s2ChrArr[s2.charAt(i) - 97] += 1;
		}

		for (int i = 0; i < ALPHABET_CNT; i++) {
			if (s1ChrArr[i] != s2ChrArr[i]) {
				return false;
			}
		}

		return true;
	}
}
