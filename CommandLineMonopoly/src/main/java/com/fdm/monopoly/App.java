package com.fdm.monopoly;

import java.util.Scanner;

import com.fdm.board.Board;
import com.fdm.players.AI;
import com.fdm.players.Human;
import com.fdm.players.Player;

/**
 * MONOPOLLY!!!
 * 
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Player[] players;
		print("MONOPOLY!!!");
		
		int noOfPlayers = scan(1, "Enter number of human players: ");
		int aiPlayers = scan(1, "Enter number of AI players: ");
		players = new Player[(noOfPlayers + aiPlayers)];
		
		for (int i = 0; i < noOfPlayers; i++) {
			String name = scan("Enter human player " + i + "'s name: ");
			players[i] = new Human(name, 1500);
		}
		
		for (int i = 0; i < aiPlayers; i++) {
			String name = scan("Enter AI player " + i + "'s name: ");
			players[noOfPlayers + i] = new AI(name, 1500, AI.Difficulty.EASY);
		}
		
		Board board = new Board(players);
		
	}

	/**
	 * @param string
	 */
	private static void print(String string) {
		System.out.println(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("(slepp interupted)");
		}
	}

	/**
	 * @param prompt
	 * @return
	 */
	private static String scan(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	/**
	 * @param x
	 * @param prompt
	 * @return
	 */
	private static int scan(int x, String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				int input = Integer.parseInt(scanner.nextLine());
				if (input > 0) {
					return input;
				}
			} catch (NumberFormatException e) {
			}
			print("Illegal Input Detected!");
		}
	}
}
