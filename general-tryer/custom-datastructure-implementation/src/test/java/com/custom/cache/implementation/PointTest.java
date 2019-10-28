package com.custom.cache.implementation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.custom.datastructure.threeD.distance.Point;

public class PointTest {

	@Test
	public void pointDistanceTest() {
		
		Point p1 = new Point(8, 2, 6);
		Point p2 = new Point(8, 6, 3);

		assertTrue(Double.compare(5, p1.distance(p2)) == 0);
		assertTrue(Double.compare(5, p2.distance(p1)) == 0);
	}
}
