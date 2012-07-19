/**
 * 
 */
package com.fdm.players;

/**
 * @author michael.wambeek
 * 
 */
public class AI extends Player {
	private Difficulty difficulty;

	/**
	 * @author michael.wambeek
	 *
	 */
	public static enum Difficulty {
		EASY, MEDIUM, HARD, LEGENDARY;
		public int getValue(Difficulty d) {
			switch (d) {
			case EASY:
				return 1;
			case MEDIUM:
				return 2;
			case HARD:
				return 3;
			case LEGENDARY:
				return 4;
			}
			return 0;
		}
	}

	/**
	 * @param name
	 * @param money
	 * @param difficulty
	 */
	public AI(String name, int money, Difficulty difficulty) {
		super(name, money);
		this.difficulty = difficulty;
	}
	
	/**
	 * @return
	 */
	public Difficulty getDifficulty(){
		return difficulty;
	}

}
