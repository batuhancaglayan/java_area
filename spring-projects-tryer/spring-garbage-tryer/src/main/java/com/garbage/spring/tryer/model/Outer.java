package com.garbage.spring.tryer.model;

public class Outer {

	public class Inner {

		private String name;

		public Inner(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		protected void finalize() throws Throwable {
			System.out.println("finalize");
			super.finalize();
		}
	}
}
