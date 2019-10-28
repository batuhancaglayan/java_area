package com.object.oriented.design.generic.deck.cards.model;

import java.util.List;

public class Deck<T extends Card> {

	private List<T> cards;
}
