/**
 * 
 */
package com.fdm.squares;

import java.util.HashSet;

import com.fdm.cards.Card;

/**
 * @author michael.wambeek
 *
 */
public abstract class CardDeck extends Square{
	protected HashSet<Card> cards;

	/**
	 * @param name
	 */
	public CardDeck(String name) {
		super(name);
	}

}
