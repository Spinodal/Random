/**
 * 
 */
package com.fdm.squares;

import java.io.IOException;

import com.fdm.players.Player;


/**
 * @author michael.wambeek
 *
 */
public class BuyableGroup {
	private Buyable[] group;
	private String groupName;
	
	/**
	 * @param groupName
	 * @param group
	 */
	public BuyableGroup(String groupName, Buyable[] group){
		this.groupName = groupName;
		this.group = group;
	}
	
	/**
	 * @param groupName
	 */
	public BuyableGroup(String groupName, int size) {
		this.groupName = groupName;
		this.group = new Buyable[size];
	}

	/**
	 * @return
	 */
	public String getGroupName(){
		return groupName;
	}
	
	
	
	/**
	 * @param player
	 * @return
	 */
	public boolean playerOwnsGroup(Player player){
		for(Buyable square : group){
			if(!player.equals(square.getOwner())){
				return false;
			}
		}
		return true;
	}
	
	public Buyable addToGroup(Buyable buyable){
		for(int i=0; i<group.length; i++){
			if(group[i] == null){
				group[i] = buyable;
				return buyable;
			}
		}
		throw new IndexOutOfBoundsException(){
			@Override
			public String getMessage() {
				return "Add Failed";
			}
		};
	}
	
	

}
