package com.algorithm.tryer.sockmerchant;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class SockMerchant {

	public static int sockMerchant(int n, int[] ar) {

		Map<Integer, Integer> availableSocks = new HashMap<>();
		for (int i = 0; i < ar.length; i++) {
			int sockColor = ar[i];
			int numberOfSock = 0;
			if (availableSocks.containsKey(sockColor)) {
				numberOfSock = availableSocks.get(sockColor);
			}

			availableSocks.put(sockColor, numberOfSock + 1);
		}

		return availableSocks.entrySet().stream().map(x -> (int) x.getValue() / 2).reduce(0, Integer::sum); 
	}
}
