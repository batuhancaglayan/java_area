package com.algorithm.tryer.jumpingonclouds;

public final class JumpingOnTheClouds {

	public static int jumpingOnClouds(int[] c) {

		int cLength = c.length;
		int currentPositionIndex = 0;
		int jumpCount = 0;
		while (currentPositionIndex < cLength) {

			int canBeJumpIndex = 1;
			if (currentPositionIndex + 2 < cLength) {
				canBeJumpIndex = canBeJumpIndex + (c[currentPositionIndex + 2] == 0 ? 1 : 0);
			}

			currentPositionIndex = currentPositionIndex + canBeJumpIndex;
			jumpCount++;
			if (canBeJumpIndex == 0 || currentPositionIndex == cLength - 1) {
				break;
			}
		}

		return jumpCount;
	}
}
