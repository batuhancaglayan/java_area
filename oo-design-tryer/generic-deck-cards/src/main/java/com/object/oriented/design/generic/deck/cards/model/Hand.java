package com.object.oriented.design.generic.deck.cards.model;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card> {

	private List<T> cards;

	public Hand() {
		this.cards = new ArrayList<T>();
	}

	public int score() {
		int score = 0;
		for (T card : cards) {
			score += card.value();
		}

		return score;
	}

	public void addCard(T card) {
		this.cards.add(card);
	}
}
