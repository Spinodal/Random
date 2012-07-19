/**
 * 
 */
package com.fdm.cards;


/**
 * @author michael.wambeek
 *
 */
public abstract class Card {
	protected String message;


	public Card(String message) {
		this.message = message;
	}
	
	protected abstract void action();

	
}
