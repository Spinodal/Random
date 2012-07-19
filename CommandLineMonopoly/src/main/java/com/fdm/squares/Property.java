/**
 * 
 */
package com.fdm.squares;


/**
 * @author michael.wambeek
 *
 */
public class Property extends Buyable{
	private int houses = 0;
	/**
	 * @param name
	 * @param price
	 */
	public Property(String name, int price){
		super(name, price);
	}

	/**
	 * @return
	 */
	public boolean addHouse(){
		if(houses < 5){
			houses++;
			return true;
		}
		return false;
	}
	
	/**
	 * @return
	 */
	public boolean removeHouse(){
		if(houses > 0){
			houses--;
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Property [name=" + name + ", price=" + price
				+ ", mortgagePrice=" + mortgagePrice + "]";
	}

}
