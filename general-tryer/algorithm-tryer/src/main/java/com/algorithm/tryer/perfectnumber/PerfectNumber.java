package com.algorithm.tryer.perfectnumber;

public class PerfectNumber {
	
	public static boolean isPerfect(int n) {
		// To store sum of divisors
		int sum = 1;

		// Find all divisors and add them
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i != n)
					sum = sum + i + n / i;
				else
					sum = sum + i;
			}
		}
		// If sum of divisors is equal to
		// n, then n is a perfect number
		if (sum == n && n != 1)
			return true;

		return false;
	}
}
