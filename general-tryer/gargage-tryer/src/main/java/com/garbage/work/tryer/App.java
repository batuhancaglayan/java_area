package com.garbage.work.tryer;

import com.garbage.work.tryer.model.Outer;

public class App {
	public static void main(String[] args) {
		Outer outer = new Outer();
		String name = "deneme";
		int loop = 0;
		while (true) {
			loop++;
			Outer.Inner inner = outer.new Inner(name + loop);
			inner.getName();
		}
	}
}
