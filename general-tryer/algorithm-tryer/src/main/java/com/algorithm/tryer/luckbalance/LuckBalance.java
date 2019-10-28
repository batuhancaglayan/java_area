package com.algorithm.tryer.luckbalance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LuckBalance {

	public static int luckBalance(int k, int[][] contests) {

		int totalLuck = 0;
		List<Integer> importantContestLucks = new ArrayList<>();
		for (int i = 0; i < contests.length; i++) {
			int luckValue = contests[i][0];
			if (contests[i][1] == 1) {
				importantContestLucks.add(luckValue);
			}

			totalLuck = totalLuck + luckValue;
		}

		Integer arr[] = importantContestLucks.toArray(new Integer[importantContestLucks.size()]);
		Arrays.sort(arr);
		int canBeWin = Math.max(0, importantContestLucks.size() - k);
		int minusValue = 0;
		for (int i = 0; i < canBeWin; i++) {
			minusValue = minusValue + arr[i];
		}

		return totalLuck - minusValue * 2;
	}
}
