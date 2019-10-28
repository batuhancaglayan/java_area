package com.algorithm.tryer.subset;

public final class Subset {

	public static void printSubsets(int[] arr) {

		int arrLength = arr.length;
		int posiableSubsetCount = (int) Math.pow(2, arrLength);
		for (int i = 0; i < posiableSubsetCount; i++) {

			StringBuilder strBldr = new StringBuilder();
			strBldr.append("{ ");
			for (int j = 0; j < arrLength; j++) {
				int currIndexPower = (int) Math.pow(2, j);
				if ((i & currIndexPower) > 0) {
					strBldr.append(arr[j] + " ");
				}
			}

			strBldr.append("}");
			System.out.println(strBldr.toString());
		}
	}
}
