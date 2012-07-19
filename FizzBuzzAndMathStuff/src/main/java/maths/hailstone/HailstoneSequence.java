/**
 * 
 */
package maths.hailstone;

import java.util.Scanner;

/**
 * @author michael.wambeek
 * 
 */
public class HailstoneSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//inputPrompter();
		 maxSequencer(1000000);
	}

	/**
	 * 
	 */
	private static void maxSequencer(int max) {
		int number = 0;
		int maxCount = 0;
		for (int i = 0; i < max; i++) {
			int check = hailer(i, false);
			if (check > maxCount) {
				maxCount = check;
				number = i;
			}
		}
		System.out.println("Number: " + number + " with " + maxCount);

	}

	/**
	 * 
	 */
	public static void inputPrompter() {
		while (true) {
			System.out.print("Enter number:\n>>:");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			try {
				int hail = Integer.parseInt(input);
				hailer(hail, true);
				System.out.println();
				Thread.sleep(1000);
			} catch (NumberFormatException e) {
				System.out.println("illegal number");
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * @param hail
	 * @return
	 */
	public static int hailer(int hail, boolean output) {
		int counter = 1;
		if (output) {
			System.out.print(hail + " ");
		}
		while (hail > 1) {

			if (hail % 2 == 0) {
				// even number calculation
				hail /= 2;
			} else {
				// odd number calculation
				hail = (hail * 3) + 1;
			}
			counter++;

			// display nicely by wrapping around every 10th calculation
			if (output) {
				if (counter % 10 == 0) {
					System.out.println(hail);
				} else {
					System.out.print(hail + " ");
				}
			}

		}
		if (output) {
			System.out.println("\nThere were " + counter
					+ " numbers in the sequence.");
		}
		return counter;
	}

}
