package com.deneme.zuul.tryer.filter;

public enum ZuulFilterType {

	PRE("pre"),
	
	POST("post");

	private String value;

	ZuulFilterType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
