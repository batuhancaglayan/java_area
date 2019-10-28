package com.algorithm.tryer.anagram;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Anagram {

	public static int makeAnagram(String a, String b) {

		long itemIsExist = 0;
		Map<Character, Long> aCharGroup = a.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Character, Long> bCharGroup = b.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for (Entry<Character, Long> aCharGroupItem : aCharGroup.entrySet()) {

			if (bCharGroup.containsKey(aCharGroupItem.getKey())) {
				long aItemCount = aCharGroupItem.getValue();
				long bItemCount = bCharGroup.get(aCharGroupItem.getKey());
				itemIsExist = itemIsExist + Math.min(aItemCount, bItemCount) * 2;
				bCharGroup.remove(aCharGroupItem.getValue());
			}
		}

		return (int) (a.length() + b.length() - itemIsExist);
	}
}
