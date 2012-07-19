/**
 * 
 */
package com.fdm.squares;

import com.fdm.players.Player;

/**
 * @author michael.wambeek
 * 
 */
public class Go extends Special {

	public Go() {
		super("Go");
	}
	
	@Override
	public void land(Player player) {
		super.land(player);
		player.addMoney(400);
	}
	
	@Override
	public void moveOver(Player player) {
		super.moveOver(player);
		player.addMoney(200);
	}

}
