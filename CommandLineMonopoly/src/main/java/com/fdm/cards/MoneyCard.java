/**
 * 
 */
package com.fdm.cards;

/**
 * @author michael.wambeek
 * 
 */
public class MoneyCard extends Card {
	private int amount;
	private boolean fromEachPlayer = false;
	private boolean repairs = false;
	private int houseCost;
	private int hotelCost;

	/**
	 * @param message
	 * @param amount
	 */
	public MoneyCard(String message, int amount) {
		super(message);
		this.amount = amount;
	}

	/**
	 * @param message
	 * @param amount
	 * @param fromEachPlayer
	 */
	public MoneyCard(String message, int amount, boolean fromEachPlayer) {
		this(message, amount);
		this.fromEachPlayer = fromEachPlayer;
	}

	/**
	 * @param message
	 * @param repairsCosts
	 */
	public MoneyCard(String message, int[] repairsCosts) {
		super(message);
		this.repairs = true;
		this.houseCost = repairsCosts[0];
		this.hotelCost = repairsCosts[1];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fdm.cards.Card#action()
	 */
	@Override
	protected void action() {
		if (repairs) {
			System.out.println(">>money action: repairs house=" + houseCost
					+ " hotel=" + hotelCost);
		} else if (fromEachPlayer) {
			System.out.println(">>money action: " + amount
					+ " From each player");
		} else {
			System.out.println(">>money action: " + amount);
		}
	}

}
