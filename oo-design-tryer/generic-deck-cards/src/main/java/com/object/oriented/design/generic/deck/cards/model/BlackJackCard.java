package com.object.oriented.design.generic.deck.cards.model;

public class BlackJackCard extends Card {

	public BlackJackCard(int value, CardType cardType) {
		super(value, cardType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int value() {
		if (this.isAce()) {
			return 1;
		} else if (this.isFaceCard()) {
			return 10;
		} else {
			return super.value;
		}
	}

	public boolean isAce() {
		return super.value == 1;
	}

	public boolean isFaceCard() {
		return value >= 11 && value <= 13;
	}
}
