package com.object.oriented.design.generic.deck.cards.model;

public enum CardType {
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;

	private CardType(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	public static CardType getSuitFromValue(int value) {
		for (CardType cardType : CardType.values()) {
			if (cardType.getValue() == value) {
				return cardType;

			}
		}
		return null;
	}
}
