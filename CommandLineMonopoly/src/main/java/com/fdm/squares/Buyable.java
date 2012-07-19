/**
 * 
 */
package com.fdm.squares;

import com.fdm.players.Player;

/**
 * @author michael.wambeek
 *
 */
public abstract class Buyable extends Square {
	
	protected int price;
	protected int mortgagePrice;
	protected Player owner;

	public Buyable(String name, int price){
		super(name);
		this.price = price;
		this.mortgagePrice = 0; //TODO
		this.owner = null;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the mortgagePrice
	 */
	public int getMortgagePrice() {
		return mortgagePrice;
	}

	/**
	 * @param p
	 */
	public void setOwner(Player p) {
		owner = p;
	}

	/**
	 * @return
	 */
	public Player getOwner() {
		return owner;
	}

}
