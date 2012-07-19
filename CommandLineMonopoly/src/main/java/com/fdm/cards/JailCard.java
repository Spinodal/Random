/**
 * 
 */
package com.fdm.cards;

/**
 * @author michael.wambeek
 *
 */
public class JailCard extends Card{

	public JailCard() {
		super("Go Directly to Jail!!!");
	}

	@Override
	protected void action() {
		System.out.println(">>jail action");
	}

}
