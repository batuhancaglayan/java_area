package com.custom.datastructure.version.compare;

import java.util.Arrays;
import java.util.Comparator;

public class VersionComparator implements Comparator<String> {

	@Override
	public int compare(String version1, String version2) {

		Integer version1Arr[] = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
		Integer version2Arr[] = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
		int version1Length = version1Arr.length;
		int version2Length = version2Arr.length;
		int idx = 0;
		while (idx < version1Length || idx < version2Length) {
			if (idx < version1Length && idx < version2Length) {
				if (version1Arr[idx] < version2Arr[idx]) {
					return -1;
				} else if (version1Arr[idx] > version2Arr[idx]) {
					return 1;
				}
			} else if (idx < version1Length) {
				if (version1Arr[idx] > 0) {
					return 1;
				}
			} else if (idx < version2Length) {
				if (version2Arr[idx] > 0) {
					return -1;
				}
			}

			idx++;
		}

		return 0;
	}
}
