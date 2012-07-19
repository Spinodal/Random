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
public abstract class Square {
	protected String name;
	protected HashSet<Player> playersOnSquare;
	
	/**
	 * @param name
	 */
	public Square(String name){
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param player
	 */
	public void land(Player player){
		this.playersOnSquare.add(player);
		System.out.println(player.getName() + " lands on " + this.name);
	}
	
	/**
	 * @param player
	 */
	public void moveForward(Player player){
		this.playersOnSquare.remove(player);
		System.out.println(player.getName() + " leaves " + this.name);
	}
	
	public void moveBackward(Player player){
		this.playersOnSquare.remove(player);
		System.out.println(player.getName() + " leaves " + this.name);
	}
	
	/**
	 * @param player
	 */
	public void moveOver(Player player){
		System.out.println(player.getName() + " moves past " + this.name);
	}

}
