package com.spring.multithread.tryer.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionDivider<T> {

	public List<List<T>> divide(List<T> list, int divideSize) {
		int mainListSize = list.size();
		int parts = mainListSize / divideSize;

		boolean isDivisible = mainListSize % divideSize == 0;

		if (!isDivisible) {
			parts++;
		}

		List<List<T>> dividedCollection = new ArrayList<>(parts);
		for (int i = 0; i < parts; i++) {
			int currentNumber = divideSize * i;

			int lastSize = currentNumber + divideSize;

			if (lastSize > mainListSize) {
				dividedCollection.add(new ArrayList<>(list.subList(currentNumber, mainListSize)));
			} else {
				dividedCollection.add(new ArrayList<>(list.subList(currentNumber, currentNumber + divideSize)));
			}
		}

		return dividedCollection;
	}
}