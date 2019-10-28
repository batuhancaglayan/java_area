package com.algorithm.tryer.alternatingcharacters;

public final class AlternatingCharacters {

	public static int alternatingCharacters(String s) {

		int minimumRemoveCount = 0;
		char sCharArr[] = s.toCharArray();

		char lastChr = sCharArr[0];
		for (int i = 1; i < sCharArr.length; i++) {
			char currChr = sCharArr[i];
			if (lastChr == currChr) {
				minimumRemoveCount++;
			} else {
				lastChr = currChr;
			}
		}

		return minimumRemoveCount;
	}
}
