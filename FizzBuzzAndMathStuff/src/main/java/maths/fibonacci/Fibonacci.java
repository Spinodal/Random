/**
 * 
 */
package maths.fibonacci;

import java.math.BigInteger;

/**
 * @author michael.wambeek
 * 
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======Fibonacci Sequence======");
		try {
			BigInteger x = BigInteger.ZERO, y = BigInteger.ONE;
			System.out.println("1:\t" + x);
			Thread.sleep(500);
			System.out.println("2:\t" + y);
			Thread.sleep(500);
			for (int i = 3; i <= 100; i++) {
				BigInteger temp;
				temp = x.add(y);
				x = y;
				y = temp;
				System.out.println(i + ":\t" + y);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
