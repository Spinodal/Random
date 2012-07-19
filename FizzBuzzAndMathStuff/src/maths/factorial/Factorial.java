/**
 * 
 */
package maths.factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author michael.wambeek
 *
 */
public class Factorial {

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
			try{
			BigInteger number = new BigInteger(input);
			System.out.print(number+"!\t= ");
			System.out.println("\n\t= " +factorial(number));
			}catch(NumberFormatException e){
				System.out.println("Please enter a valid number");
			}
		}
			

	}
	
	public static BigInteger factorial(BigInteger x){
		if(x.equals(BigInteger.ONE)){
			System.out.print(x);
			return x;
		}
		else{
			System.out.print(x+"*");
			return x.multiply(factorial(x.subtract(BigInteger.ONE)));
		}
	}
		
		

}
