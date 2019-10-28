package com.algorithm.tryer.newyearchaos;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.x500.X500Principal;

public final class NewYearChaos {

	public static void minimumBribes(Integer[] q) {

		int aLength = q.length;
		int bribeNumber = 0;
		boolean isChaotic = false;
		for (int i = 0; i < aLength; i++) {
			int currentValue = q[i];
			int positionMustBe = currentValue - 1 - i;
			if (positionMustBe > 2) {
				isChaotic = true;
				break;
			}

			for (int j = Math.max(0, q[i] - 2); j < i; j++) {
				if (currentValue < q[j]) {
					bribeNumber++;
				}
			}
		}

//		for (int i = 0; i < aLength; i++) {
//			int currentValue = q[i];
//			int positionMustBe = currentValue - 1;
//			if (positionMustBe == i) {
//				continue;
//			}
//
//			if (i < positionMustBe) {
//				int personBribeNumber = positionMustBe - i;
//				if (personBribeNumber > 2) {
//					isChaotic = true;
//					break;
//				}
//
//				bribeNumber = bribeNumber + positionMustBe - i;
//			} else {
//
//				int tempBribe = 0;
//				if (i + 1 < aLength && currentValue > q[i + 1]) {
//					tempBribe++;
//				}
//
//				if (i + 2 < aLength && tempBribe == 1) {
//					if (i + 1 < aLength && currentValue > q[i + 1]) {
//						tempBribe++;
//					}
//				}
//
//				bribeNumber = bribeNumber + tempBribe;
//			}
//		}

//		else if (i == currentValue && i + 1 <= aLength && currentValue > q[i + 1]) {
//			bribeNumber = bribeNumber + 1;
//		}

//		Map<Integer, Integer> bribeMap = new HashMap<>();
//		for (int i = 0; i < aLength; i++) {
//			int currentValue = q[i];
//			if (currentValue - 1 == i) {
//				continue;
//			}
//
//			if (currentValue >= i) {
//				int bribeOfPerson = currentValue - 1 - i;
//				if (bribeOfPerson > 2) {
//					break;
//				}
//				
//				if (bribeOfPerson < 1) {
//					continue;
//				}
//
//				if (!bribeMap.containsKey(currentValue)) {
//					bribeMap.put(currentValue, bribeOfPerson);
//				}
//			} else {
//				int diffirencePosition = currentValue - i - 1;
//				int diffirencePositionLimit = 0;
//				for (int j = currentValue; j <= i; j++) {
//				
//					if (bribeMap.containsKey(j)) {
//						diffirencePositionLimit = diffirencePositionLimit + bribeMap.get(j);
//					}
//				}
//				
//				if (diffirencePositionLimit < Math.abs(diffirencePosition)) {
//					isChaotic = true;
//					break;
//				}
//			}
//
//			if (isChaotic) {
//				break;
//			}
//		}

//		for (int i = 0; i < aLength; i++) {
//			int currentValue = q[i];
//			if (currentValue - 1 == i) {
//				continue;
//			}
//
//			int bribeOfPerson = 0;
//			for (int j = i + 1; j < aLength; j++) {
//				int neighbourValue = q[j];
//				if (currentValue > neighbourValue) {
//					bribeOfPerson++;
//				}
//
//				if (bribeOfPerson >= 3) {
//					isChaotic = true;
//					break;
//				}
//			}
//
//			bribeNumber = bribeNumber + bribeOfPerson;
//			if (isChaotic) {
//				break;
//			}
//		}
		// bribeNumber = bribeMap.values().stream().reduce(0, Integer::sum);
		System.out.println(isChaotic ? "Too chaotic" : bribeNumber);
	}
}
