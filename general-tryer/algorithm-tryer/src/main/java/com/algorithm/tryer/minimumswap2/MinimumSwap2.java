package com.algorithm.tryer.minimumswap2;

public final class MinimumSwap2 {

	public static int minimumSwaps(int[] arr) {

		int swapCount = 0;
		int arrLength = arr.length;
		for (int i = 0; i < arrLength; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arrLength; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
				swapCount++;
			}

		}

		return swapCount;
	}
}
