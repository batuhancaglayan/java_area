package com.algorithm.tryer.minabsodiffinarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class MinimumAbsoluteDifferenceInAnArray {

	public static int minimumAbsoluteDifference(int[] arr) {

		Arrays.sort(arr);
		int arrLength = arr.length;
		int minAbsoluteDiffirence = Math.abs(arr[0] - arr[1]);
		for (int i = 0, n = i + 1; i < arrLength && n < arrLength; i++, n++) {
			int currValue = arr[i];
			int diffirence = Math.abs(currValue - arr[n]);
			if (minAbsoluteDiffirence > diffirence) {
				minAbsoluteDiffirence = diffirence;
			}
		}

		return minAbsoluteDiffirence;
	}
}
