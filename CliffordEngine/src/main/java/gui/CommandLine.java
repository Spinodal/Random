/**
 * 
 */
package gui;

import java.math.BigInteger;
import java.util.Scanner;

import com.fdm.clifford.Engine;
import com.fdm.exceptions.IllegalInputException;

/**
 * @author michael.wambeek
 * 
 */
public class CommandLine {

	public static void run() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Type in Cliffod code or (q)uit to exit");
		while (running) {
			System.out.print(">>: ");
			String input = sc.nextLine();
			input = input.toLowerCase();
			if (input.equals("quit") || input.equals("q")
					|| input.equals("exit")) {
				System.out.println("Goodbye.");
				running = false;
			} else {
				BigInteger result;
				try {
					result = Engine.run(input);
					System.out.println();
					System.out.println("Result: " + result.toString());
				} catch (IllegalInputException e) {
					System.out.println();
					System.err.println("Error: " + e.getMessage());
				}
			}
		}
	}
}
