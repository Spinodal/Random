/**
 * 
 */
package maths.hex;

import java.util.Scanner;

/**
 * @author michael.wambeek
 * 
 */
public class HexToDec {

	public static void main(String[] args) {
		boolean running = true;
		System.out.println("'q' to quit");
		while (running) {
			System.out.print("Enter Hex Number:\t");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine().trim();

			if (input.equals("q")) {
				running = false;
				System.out.println("quiting");
				continue;
			} else if (!input.matches("#?[0-9a-fA-F]+")) {
				System.err.println("Invalid character");
			} else {
				convert(input.toUpperCase());
			}

		}
	}

	private static void convert(String input) {
		int[][] bin = new int[input.length()][4];
		for (int i = 0; i < input.length(); i++) {
			bin[i] = HexadecimalDigit.getBinaryValue(input.charAt(i));
		}
		String binary = "";
		for (int[] arr : bin) {
			binary += "" + arr[0] + arr[1] + arr[2] + arr[3];
		}
		System.out.println("\tBinary:\t\t" + binary);

		int dec = BinaryGroup.toDecimal(bin);
		System.out.println("\tDecimal:\t" + dec);
		System.out.println();
	}
}
