/**
 * 
 */
package com.fdm.board;

import com.fdm.players.Player;
import com.fdm.squares.*;

/**
 * @author michael.wambeek
 * 
 */
public class Board {
	private Player[] players;
	private Dice dice1;
	private Dice dice2;
	private Square[] board;

	public Board(Player[] players) {
		this.players = players;
		board = new Square[40];
		dice1 = new Dice();
		dice2 = new Dice();
		
		BuyableGroup brown = new BuyableGroup("Brown", 2);
		BuyableGroup blue = new BuyableGroup("Blue" ,3);
		BuyableGroup pink = new BuyableGroup("Pink", 3);
		BuyableGroup orange = new BuyableGroup("Orange", 3);
		BuyableGroup red = new BuyableGroup("Red", 3);
		BuyableGroup yellow = new BuyableGroup("Yellow", 3);
		BuyableGroup green = new BuyableGroup("Green", 3);
		BuyableGroup purple = new BuyableGroup("Purple", 2);
		
		BuyableGroup stations = new BuyableGroup("Station", 4);
		BuyableGroup utilities = new BuyableGroup("Utility", 2);
		
		
		board[0] = new Go();
		board[1] = brown.addToGroup(new Property("Old Kent Road", 60));
		board[2] = CommunityChest.getInstance();
		board[3] = brown.addToGroup(new Property("Whitechapel Road", 60));
		board[4] = new Tax("Income Tax", 200);
		board[5] = stations.addToGroup(new Station("Kings Cross", 200));
		board[6] = blue.addToGroup(new Property("The Angel Islington", 100));
		board[7] = Chance.getInstance();
		board[8] = blue.addToGroup(new Property("Euston Road", 100));
		board[9] = blue.addToGroup(new Property("Pentoville Road", 60));
		
		board[10] = new Jail();
		board[11] = pink.addToGroup(new Property("Pall Mall", 140));
		board[12] = utilities.addToGroup(new Utility("Electric Company", 150));
		board[13] = pink.addToGroup(new Property("Whitehall", 140));
		board[14] = pink.addToGroup(new Property("Northumberland Avenue", 160));
		board[15] = stations.addToGroup(new Station("Marylebone Station", 200));
		board[16] = orange.addToGroup(new Property("Bow Street", 180));
		board[17] = CommunityChest.getInstance();
		board[18] = orange.addToGroup(new Property("Marlborough Street", 180));
		board[19] = orange.addToGroup(new Property("Vine Street", 200));
		
		board[20] = new Parking();
		board[21] = red.addToGroup(new Property("Strand", 220));
		board[22] = Chance.getInstance();;
		board[23] = red.addToGroup(new Property("Fleet Street", 220));
		board[24] = red.addToGroup(new Property("Trafalgar Square", 240));
		board[25] = stations.addToGroup(new Station("Fenchurch Street Station", 200));;
		board[26] = yellow.addToGroup(new Property("Leicester Square", 260));
		board[27] = yellow.addToGroup(new Property("Coventry Street", 260));
		board[28] = utilities.addToGroup(new Utility("Water Company", 150));
		board[29] = yellow.addToGroup(new Property("picadilly", 280));
		
		board[30] = new GoToJail();
		board[31] = green.addToGroup(new Property("Regent Street", 300));
		board[32] = green.addToGroup(new Property("Oxford Street", 300));
		board[33] = CommunityChest.getInstance();;
		board[34] = green.addToGroup(new Property("Bond Street", 320));
		board[35] = stations.addToGroup(new Station("Liverpool Street Station", 200));;
		board[36] = Chance.getInstance();;
		board[37] = purple.addToGroup(new Property("Park Lane", 350));
		board[38] = new Tax("Super Tax", 100);
		board[39] = purple.addToGroup(new Property("Mayfair", 400));

	}
	
	/**
	 * @return
	 */
	public int rollDice1(){
		return dice1.roll();
	}
	
	/**
	 * @return
	 */
	public int rollDice2(){
		return dice2.roll();
	}

	/**
	 * @return
	 */
	public int getRollDice1(){
		return dice1.getValue();
	}
	
	/**
	 * @return
	 */
	public int getRollDice2(){
		return dice2.getValue();
	}
	
	/**
	 * 
	 */
	public void move(){
		int spaces = dice1.getValue() + dice2.getValue();
		
	}

}
