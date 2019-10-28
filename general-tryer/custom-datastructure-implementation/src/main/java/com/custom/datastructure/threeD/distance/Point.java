package com.custom.datastructure.threeD.distance;

public class Point {

	private final double x;

	private final double y;

	private final double z;

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double distance(Point p2) {
		double dx = this.x - p2.x;
		double dy = this.y - p2.y;
		double dz = this.z - p2.z;

		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}
}
