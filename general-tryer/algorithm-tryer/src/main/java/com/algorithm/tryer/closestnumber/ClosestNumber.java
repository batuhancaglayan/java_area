package com.algorithm.tryer.closestnumber;

import java.util.Arrays;

public final class ClosestNumber {

	public static void distClosestNumbers(int arr[]) {

		Arrays.sort(arr);
		int arrLength = arr.length;
		int firstClosestNumber = arr[arrLength - 1];
		int secondClosestNumber = arr[arrLength - 2];
		int minDif = firstClosestNumber - secondClosestNumber;

		for (int i = arr.length - 2; i <= 0; i--) {
			int currDif = arr[i] - arr[i - 1];
			if (currDif < minDif) {
				firstClosestNumber = arr[i];
				secondClosestNumber = arr[i - 1];
				minDif = currDif;
			}
		}

		System.out.println("result is => " + minDif + " first number => " + firstClosestNumber + " second number => "
				+ secondClosestNumber);
	}
}
