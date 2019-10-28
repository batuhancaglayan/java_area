package com.algorithm.tryer.stockmaximize;

import java.util.List;

public final class StockMaximize {

	public static long stockmax(List<Integer> prices) {

		int pricesLength = prices.size();
		int maximum = prices.get(pricesLength - 1);
		long counter = 0;
		for (int i = pricesLength - 2; i >= 0; i--) {
			if (maximum > prices.get(i)) {
				counter += maximum - prices.get(i);
			} else {
				maximum = prices.get(i);
			}
		}

		return counter;
	}
}
