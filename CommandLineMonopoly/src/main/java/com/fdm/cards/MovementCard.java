/**
 * 
 */
package com.fdm.cards;

import com.fdm.squares.Square;

/**
 * @author michael.wambeek
 * 
 */
public class MovementCard extends Card {
	private Square destination;
	private boolean moveByType = false;
	private int spaces;
	private Class<?> nearestType;

	/**
	 * @param message
	 * @param destination
	 */
	public MovementCard(String message, Square destination) {
		super(message);
		this.destination = destination;
	}

	/**
	 * @param message
	 * @param spaces
	 */
	public MovementCard(String message, int spaces) {
		super(message);
		this.spaces = spaces;
	}

	public MovementCard(String message, Class<?> nearestType) {
		super(message);
		this.nearestType = nearestType;
		this.moveByType = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fdm.cards.Card#action()
	 */
	@Override
	public void action() {
		if (moveByType) {
			System.out.println(">>movement action: to nearest "+ nearestType.getName());
		} else if (destination == null) {
			System.out.println(">>movement action: " + spaces);
		} else {
			System.out.println(">>movement action:" + destination);
		}

	}

}
