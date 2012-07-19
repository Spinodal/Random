/**
 * 
 */
package com.fdm.players;

/**
 * @author michael.wambeek
 *
 */
public abstract class Player {
	private int money;
	private String name;
	
	/**
	 * @param money
	 */
	public Player(String name, int money){
		this.money = money;
		this.name = name;
	}
	
	/**
	 * @param amount
	 */
	public void addMoney(int amount){
		money += amount;
	}
	
	/**
	 * @param amount
	 */
	public void removeMoney(int amount){
		money -= amount;
	}
	
	/**
	 * @return
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * @return
	 */
	public String getName(){
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (money != other.money)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	

}
