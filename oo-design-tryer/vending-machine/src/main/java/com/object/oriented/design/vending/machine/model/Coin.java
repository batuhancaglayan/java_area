package com.object.oriented.design.vending.machine.model;

public enum Coin {

	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

	private int denomination;

	private Coin(int denomination) {
		this.denomination = denomination;
	}

	public int getDenomination() {
		return denomination;
	}

	public static Coin getCoinByValue(int value) {
		for (Coin coin : Coin.values()) {
			if (coin.getDenomination() == value) {
				return coin;
			}
		}

		return null;
	}
}
