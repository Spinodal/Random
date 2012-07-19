/**
 * 
 */
package maths.rooter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author michael.wambeek
 * 
 */
public class rooter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean running = true;
		System.out.println("'q' to quit");
		while (running) {
			System.out.print("enter a number: ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			
			if (input.equals("q")) {
				running = false;
				System.out.println("quiting");
				continue;
			}
			
			Integer number = Integer.parseInt(input);
			boolean prime = true;
			ArrayList<Integer[]> divisors = new ArrayList<Integer[]>();
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					Integer[] x = new Integer[2];
					x[0] = i;
					x[1] = (number / i);
					divisors.add(x);
					prime = false;
				}
			}
			
			if (prime) {
				System.out.println("Prime!");
			} else {
				System.out.println("NotPrime");
				for (Integer[] arr : divisors) {
					System.out.print(arr[0] + "*" + arr[1]+", ");
					
				}
				System.out.print("\n");
			}
			System.out.println("===============================");
		}
	}

}
