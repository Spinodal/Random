/**
 * 
 */
package com.fdm.cards;

/**
 * @author michael.wambeek
 *
 */
public class GetOutOfJailFreeCard extends Card {

	public GetOutOfJailFreeCard() {
		super("Get Out Of Jail Free Card!");
	}

	/* (non-Javadoc)
	 * @see com.fdm.cards.Card#action()
	 */
	@Override
	protected void action() {
		System.out.println(">>GOOJF action");
	}

}
