/**
 * 
 */
package com.fdm.squares;

import java.util.HashSet;

import com.fdm.cards.Card;
import com.fdm.cards.GetOutOfJailFreeCard;
import com.fdm.cards.JailCard;
import com.fdm.cards.MoneyCard;
import com.fdm.cards.MovementCard;

/**
 * @author michael.wambeek
 * 
 */
public class CommunityChest extends CardDeck {
	private static CommunityChest instance;
	
	private CommunityChest() {
		super("Community Chest");
		setUp();
	}
	

	private void setUp() {
		super.cards = new HashSet<Card>();
		// movement
		cards.add(new MovementCard("Advance to Go (Collect $200)", new Go()));
		// money
		cards.add(new MoneyCard("Bank error in your favor – collect $75", 75));
		cards.add(new MoneyCard("Doctor's fees – Pay $50", -50));
		cards.add(new MoneyCard(
				"It is your birthday Collect $10 from each player", 0, true));
		cards.add(new MoneyCard(
				"Grand Opera Night – collect $50 from every player for opening night seats",
				0));
		cards.add(new MoneyCard("Income Tax refund – collect $20", 20));
		cards.add(new MoneyCard("Life Insurance Matures – collect $100", 100));
		cards.add(new MoneyCard("Pay Hospital Fees of $100", -100));
		cards.add(new MoneyCard("Pay School Fees of $50", -50));
		cards.add(new MoneyCard("Receive $25 Consultancy Fee", 25));
		cards.add(new MoneyCard(
				"You have won second prize in a beauty contest– collect $10",
				10));
		cards.add(new MoneyCard("You inherit $100", 100));
		cards.add(new MoneyCard("From sale of stock you get $50", 50));
		cards.add(new MoneyCard("Holiday Fund matures - Receive $100 ", 100));
		cards.add(new MoneyCard(
				"You are assessed for street repairs – $40 per house, $115 per hotel",
				new int[] { 40, 115 }));

		// jail
		cards.add(new JailCard());

		// Get out of jail free
		cards.add(new GetOutOfJailFreeCard());
	}


	/**
	 * @return
	 */
	public static CardDeck getInstance() {
		if(instance == null){
			instance = new CommunityChest();
		}
		return instance;
	}

}
