package com.algorithm.tryer.repeatedstrings;

public final class RepeatedString {

	public static long repeatedString(String s, long n) {

		int numberOfChrACount = s.chars().map(x -> x == 'a' ? 1 : 0).reduce(0, Integer::sum);
		int sLength = s.length();
		long repeatCount = (n / sLength);
		long residue = (n % sLength);
		String sbStr = s.substring(0, (int) (residue));
		return (numberOfChrACount * repeatCount) + (sbStr.chars().map(x -> x == 'a' ? 1 : 0).reduce(0, Integer::sum));
	}
}
