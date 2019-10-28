package com.algorithm.tryer.arrayleftrotation;

public final class ArrayRotation {

	public static int[] rotLeft(int[] a, int d) {

		int arrLength = a.length;
		if (arrLength == d) {
			return a;
		}

		int[] resultArr = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {

			int estimatedDirtyIndex = arrLength < d ? i - (d % arrLength) : i - d;
			int estimatedIndex = estimatedDirtyIndex < 0 ? arrLength - Math.abs(estimatedDirtyIndex)
					: estimatedDirtyIndex;
			if (estimatedIndex > arrLength) {
				throw new IndexOutOfBoundsException("calculation process not working correctly");
			}

			resultArr[estimatedIndex] = a[i];
		}

		return resultArr;
	}
}
