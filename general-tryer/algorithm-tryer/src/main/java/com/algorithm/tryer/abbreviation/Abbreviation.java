package com.algorithm.tryer.abbreviation;

public final class Abbreviation {

//	private static int ALPHABET_CNT = 26;
//
//	private static int UPPERCASE_MINUS_LOWERCASE = 97 - 65;

	public static String abbreviation(String a, String b) {

		int c[][] = new int[3][3];
		
		if (a.length() < b.length()) {
			return "NO";
		}

		boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (j > i) {
					dp[i][j] = false;
				} else if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (j == 0) {
					dp[i][j] = !Character.isUpperCase(a.charAt(i - 1)) && dp[i - 1][j];
				} else if (Character.isUpperCase(a.charAt(i - 1))) {
					boolean tmp = a.charAt(i - 1) == b.charAt(j - 1) && dp[i - 1][j - 1];
					dp[i][j] = tmp;
				} else {
					boolean tmp = (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) && dp[i - 1][j - 1];
					boolean tmp2 = (tmp || dp[i - 1][j]);
					dp[i][j] = tmp2;
				}
			}
		}

		return dp[a.length()][b.length()] ? "YES" : "NO";

//		boolean result = true;
//		int aLength = a.length();
//		int bLength = b.length();
//		if (bLength > aLength) {
//			result = false;
//		}
//
//		if (result) {
//			char aCharArr[] = a.toCharArray();
//			char bCharArr[] = b.toCharArray();
//			int modifiedLastIndex = 0;
//			char modifiedChrArr[] = new char[bLength];
//			int emptyLoop = 0;
//			for (int i = 0; i < aCharArr.length; i++) {
//
//				char currModifyChr = aCharArr[i];
//				if (modifiedLastIndex >= bLength) {
//					if (Character.isUpperCase(currModifyChr)) {
//						if (Character.isLowerCase(modifiedChrArr[modifiedLastIndex - 1]) 
//								&& modifiedChrArr[modifiedLastIndex - 1] == Character.toLowerCase(currModifyChr)) {
//							continue;
//						}
//						
//						result = false;
//						break;
//					}
//
//					continue;
//				}
//
//				if (Character.isUpperCase(currModifyChr)) {
//					if (bCharArr[modifiedLastIndex] != currModifyChr && modifiedLastIndex > 0) {
//						if (modifiedChrArr[modifiedLastIndex - 1] == Character.toLowerCase(currModifyChr)) {
//							modifiedChrArr[modifiedLastIndex - 1] = currModifyChr;
//							continue;
//						}
//						
//						result = false;
//						break;
//					}
//
//					modifiedChrArr[modifiedLastIndex] = currModifyChr;
//					modifiedLastIndex++;
//				} else {
//					char currUpperModifyChr = Character.toUpperCase(currModifyChr);
//					if (bCharArr[modifiedLastIndex] == currUpperModifyChr) {
//
//						modifiedChrArr[modifiedLastIndex] = currModifyChr;
//						modifiedLastIndex++;
//					}else {
//						emptyLoop++;
//					}
//				}
//			}
//
//			if (modifiedLastIndex < bLength) {
//				result = false;
//			}
//		}

//		char modifyLowerChrArr[] = new char[ALPHABET_CNT];
//		char modifyUpperChrArr[] = new char[ALPHABET_CNT];
//		char matchChrArr[] = new char[ALPHABET_CNT];
//
//		for (int i = 0; i < b.length(); i++) {
//			matchChrArr[b.charAt(i) - 65] += 1;
//		}
//
//		for (int i = 0; i < a.length(); i++) {
//			char currChar = a.charAt(i);
//			if (Character.isUpperCase(currChar)) {
//				modifyUpperChrArr[currChar - 65] += 1;
//			} else {
//				modifyLowerChrArr[currChar - 97] += 1;
//			}
//
//		}
//
//		for (int i = 0; i < ALPHABET_CNT; i++) {
//			if (matchChrArr[i] == 0) {
//				continue;
//			}
//
//			int currMatchChrCount = ((int) matchChrArr[i]);
//			int currLowerChrCount = ((int) modifyLowerChrArr[i]);
//			int currUpperChrCount = ((int) modifyUpperChrArr[i]);
//			int diffirence = currMatchChrCount - currUpperChrCount;
//			if (diffirence < 0 || diffirence > currLowerChrCount) {
//				result = false;
//				break;
//			}
//
//			modifyUpperChrArr[i] = 0;
//			matchChrArr[i] = 0;
//		}
//
//		if (result) {
//			for (int i = 0; i < modifyUpperChrArr.length; i++) {
//				if ((int) modifyUpperChrArr[i] != 0 || (int) matchChrArr[i] != 0) {
//					result = false;
//					break;
//				}
//			}
//		}

//		return result ? "YES" : "NO";
	}
}
