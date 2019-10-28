package com.algorithm.tryer.ramsonnote;

import java.util.HashMap;
import java.util.Map;

public final class RansomNote {

	public static void checkMagazine(String[] magazine, String[] note) {
		boolean result = true;
		int magazineLength = magazine.length;
		int noteLength = note.length;
		if (noteLength <= magazineLength) {
			Map<String, Integer> magazineWordGroup = new HashMap<>();
			for (int i = 0; i < magazineLength; i++) {
				String relatedMagazineWord = magazine[i];
				int wordCount = !magazineWordGroup.containsKey(relatedMagazineWord) ? 1
						: magazineWordGroup.get(relatedMagazineWord) + 1;
				magazineWordGroup.put(relatedMagazineWord, wordCount);
			}

			for (int i = 0; i < noteLength; i++) {
				String relatedNoteWord = note[i];
				if (!magazineWordGroup.containsKey(relatedNoteWord)) {
					result = false;
					break;
				}

				int availableWordCount = magazineWordGroup.get(relatedNoteWord) - 1;
				if (availableWordCount < 0) {
					result = false;
					break;
				}

				magazineWordGroup.put(relatedNoteWord, availableWordCount);
			}
		} else {
			result = false;
		}

		System.out.println(result ? "Yes" : "No");
	}
}
