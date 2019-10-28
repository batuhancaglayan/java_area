package com.algorithm.tryer.markandtoys;

import java.util.Arrays;

public final class MarkAndToys {

	public static int maximumToys(int[] prices, int k) {

		int toysWilbeBuy = 0;
		Arrays.sort(prices);
		for (int i = 0; i < prices.length; i++) {
			int price = prices[i];
			if (k >= price) {
				k = k - price;
				toysWilbeBuy++;
			}
		}

		return toysWilbeBuy;
	}
}
