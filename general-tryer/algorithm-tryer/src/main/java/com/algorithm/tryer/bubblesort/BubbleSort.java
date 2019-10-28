package com.algorithm.tryer.bubblesort;

public final class BubbleSort {

	public static void countSwaps(int[] a) {

		int iterationCount = 0;
		int aLength = a.length;
		for (int i = 0; i < aLength - 1; i++) {
	
			boolean swapped = false;
			for (int j = 0; j < aLength - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swapped = true;
					iterationCount = iterationCount + 1;
				}
			}

			if (!swapped) {
				break;
			}
		}

		System.out.println(String.format("Array is sorted in %d swaps.", iterationCount));
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[aLength - 1]);
	}

}
