/**
 * 
 */
package maths.stringAdder;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author michael.wambeek
 * 
 */
public class StringAdder {

	/**
	 * -inputs a String from a user. Expect the String to be a series of numbers
	 * each separated by a space (e.g., "11 2 36.4 4 8.9 7.6 3 256").
	 * 
	 * -converts the String into the series of numbers that it represents.
	 * 
	 * -adds the numbers together.
	 * 
	 * -displays the result to the user.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter String:");
			String input = scanner.nextLine();

			String[] inputs = input.split(" ");

			BigDecimal total = BigDecimal.ZERO;
			for (String s : inputs) {
				BigDecimal x;
				if(s.startsWith("0x")){
					x = new BigDecimal(Integer.parseInt(s.substring(2), 16));
				}
				else if(s.startsWith("0") && !s.contains(".")){
					x = new BigDecimal(Integer.parseInt(s.substring(1), 8));
				}
				else{
					x = new BigDecimal(s);
				}
				total = total.add(x);
			}
			System.out.println("Total: "+total);
		}
	}

}
