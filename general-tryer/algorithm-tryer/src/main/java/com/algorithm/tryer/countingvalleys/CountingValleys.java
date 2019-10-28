package com.algorithm.tryer.countingvalleys;

public final class CountingValleys {
	public static int countingValleys(int n, String s) {

		int valleyCount = 0;
		char sChrArr[] = s.toCharArray();
		int altitude = sChrArr[0] == 'D' ? -1 : +1;
		for (int i = 1; i < sChrArr.length; i++) {
			char currActionChr = sChrArr[i];
			altitude = altitude + (currActionChr == 'D' ? -1 : +1);
			if (altitude == 0 && currActionChr == 'U') {
				valleyCount++;
			}
		}

		return valleyCount;
	}
}
