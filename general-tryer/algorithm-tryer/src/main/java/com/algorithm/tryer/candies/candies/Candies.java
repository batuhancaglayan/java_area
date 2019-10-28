package com.algorithm.tryer.candies.candies;

public final class Candies {

	public static long candies(int n, int[] arr) {

		int sum = 0;
		int arrLength = arr.length;
		int candies[] = new int[arrLength];

		candies[0] = 1;
		for (int i = 1; i < arrLength; i++) {
			if (arr[i] > arr[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}

		sum = candies[arrLength - 1];

		for (int i = arrLength - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1] && candies[i] <= candies[i + 1]) {
				candies[i] = candies[i + 1] + 1;
			}

			sum += candies[i];
		}

		return sum;
	}
}
