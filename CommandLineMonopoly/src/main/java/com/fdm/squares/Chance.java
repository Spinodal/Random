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
public class Chance extends CardDeck {
	private static Chance instance;

	/**
	 * 
	 */
	private Chance() {
		super("Chance");
		setUp();
	}

	/**
	 * create cards
	 */
	private void setUp() {
		super.cards = new HashSet<Card>();

		// movement
		cards.add(new MovementCard("Advance to Go (Collect $200)", new Go()));
		cards.add(new MovementCard("Advance to Illinois Ave.", new Property("",
				0)));
		cards.add(new MovementCard(
				"Advance token to nearest Utility. If unowned, you may buy it from the Bank."
						+ " If owned, throw dice and pay owner a total ten times the amount thrown.",
				Utility.class));
		cards.add(new MovementCard(
				"Advance token to the nearest Railroad and pay owner twice the rental to which"
						+ " he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank."
						+ " (There are two of these.)", Station.class));
		cards.add(new MovementCard(
				"Advance to St. Charles Place – if you pass Go, collect $200",
				new Property("", 0)));
		cards.add(new MovementCard("Go back 3 spaces", 3));
		cards.add(new MovementCard(
				"Take a trip to Reading Railroad – if you pass Go collect $200",
				new Property("", 0)));
		cards.add(new MovementCard(
				"Take a walk on the Boardwalk – advance token to Boardwalk",
				new Property("", 0)));

		// money
		cards.add(new MoneyCard("Bank pays you dividend of $50", 50));
		cards.add(new MoneyCard(
				"Make general repairs on all your property – for each house pay $25 – for each hotel $100",
				new int[] { 25, 100 }));
		cards.add(new MoneyCard("Pay poor tax of $15", -15));
		cards.add(new MoneyCard(
				"You have been elected chairman of the board – pay each player $50",
				-50, true));
		cards.add(new MoneyCard("Your building loan matures – collect $150",
				150));
		cards.add(new MoneyCard(
				"You have won a crossword competition - collect $100", 100));

		// jail
		cards.add(new JailCard());

		// get out of jail free
		cards.add(new GetOutOfJailFreeCard());

	}

	public static Chance getInstance() {
		if (instance == null) {
			instance = new Chance();
		}
		return instance;
	}

}
