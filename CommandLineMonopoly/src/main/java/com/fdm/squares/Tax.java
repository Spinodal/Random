/**
 * 
 */
package com.fdm.squares;

/**
 * @author michael.wambeek
 *
 */
public class Tax extends Special {
	private int taxAmount;

	public Tax(String name, int taxAmount) {
		super(name);
		this.taxAmount = taxAmount;
	}

}
