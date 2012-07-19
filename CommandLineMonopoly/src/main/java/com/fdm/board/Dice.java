/**
 * 
 */
package com.fdm.board;

import java.util.Random;

/**
 * @author michael.wambeek
 *
 */
public class Dice {
	private int value;
	
	/**
	 * @return
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * @return
	 */
	public int roll(){
		Random random = new Random();
		value = random.nextInt(6) + 1;
		return value;
	}
	
}
