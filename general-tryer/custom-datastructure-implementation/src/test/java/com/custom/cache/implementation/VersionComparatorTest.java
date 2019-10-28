package com.custom.cache.implementation;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

import com.custom.datastructure.version.compare.VersionComparator;

public class VersionComparatorTest {

	@Test
	public void versionComparator() {

		Comparator<String> versionComparator = new VersionComparator();
		
		assertTrue(versionComparator.compare("1.1.1", "1.1.0") == 1);
		assertTrue(versionComparator.compare("2.1.1", "1.1.1") == 1);
		assertTrue(versionComparator.compare("1.1.1.1", "1.1.1") == 1);
		assertTrue(versionComparator.compare("1.1.1", "1.1.1") == 0);
		assertTrue(versionComparator.compare("1.1.1.1", "1.1.1.0") == 1);
		assertTrue(versionComparator.compare("1.1.1", "1.1.2") == -1);
		assertTrue(versionComparator.compare("1.1.1", "1.2.1") == -1);
		assertTrue(versionComparator.compare("1.1.1", "2.1.1") == -1);
		assertTrue(versionComparator.compare("1.1.1", "1.1.1.2") == -1);
	}
}
