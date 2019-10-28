package com.algorithm.tryer.substring;

public final class Substring {

	public static void printAllSubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}
}
