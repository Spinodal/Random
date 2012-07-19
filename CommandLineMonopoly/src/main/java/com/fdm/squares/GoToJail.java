/**
 * 
 */
package com.fdm.squares;

import com.fdm.players.Player;

/**
 * @author michael.wambeek
 *
 */
public class GoToJail extends Special {

	public GoToJail() {
		super("Go To Jail");
	}
	
	@Override
	public void land(Player player) {
		System.out.println("Player goes to Jail");
	}

}
