/**
 * 
 */
package com.fdm.squares;

import java.util.HashSet;

import com.fdm.players.Player;

/**
 * @author michael.wambeek
 * 
 */
public class Jail extends Square {
	private HashSet<Player> jail;

	public Jail() {
		super("Jail");
	}

	@Override
	public void land(Player player) {
		// TODO Auto-generated method stub
		super.land(player);
	}

	@Override
	public void moveForward(Player player) {
		if (jail.contains(player)) {
			System.out.println("player in jail");
		} else {
			super.moveForward(player);
		}
	}

}
