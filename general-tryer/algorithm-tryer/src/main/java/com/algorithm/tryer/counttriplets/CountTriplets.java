package com.algorithm.tryer.counttriplets;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CountTriplets {

	public static long countTriplets(List<Long> arr, long r) {

		int arrLength = arr.size();
		Map<Long, Long> numberGroup = arr.stream().sorted()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int groupSize = numberGroup.size();
		if (r == 1) {
			
			//numberGroup.values().stream().map(x-> x).max(x -> x);
			if (!numberGroup.containsKey(r)) {
				return 0;
			}
			
			int oneValueCount = numberGroup.get(r).intValue();
			long fak1 = 1;
			for (int i = oneValueCount; i > oneValueCount - 3; i--) {
				fak1 *= i;
			}

			return fak1 / 6;
		}

		if (groupSize < 3) {
			return 0;
		}

		if (arrLength == groupSize) {
			return groupSize - 1;
		}

		return (groupSize - 2) * ((arrLength - groupSize) * 2);

//		List<Integer> tripletMultiplier = new ArrayList<>();
//
////		for (Map.Entry<Long, Long> groupItem : numberGroup.entrySet()) {
////
////		}
//
//		return -1;
	}
}
