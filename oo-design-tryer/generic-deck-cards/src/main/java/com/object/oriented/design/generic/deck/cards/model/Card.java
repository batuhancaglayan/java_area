package com.object.oriented.design.generic.deck.cards.model;

public abstract class Card {

	private boolean available = true;

	protected int value;

	protected CardType cardType;

	public Card(int value, CardType cardType) {
		this.value = value;
		this.cardType = cardType;
	}

	public abstract int value();

	public boolean isAvailable() {
		return available;
	}

	public void markUnavailable() {
		available = false;
	}

	public void markAvailable() {
		available = true;
	}
}
