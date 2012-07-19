/**
 * 
 */
package maths.hex;

/**
 * @author michael.wambeek
 * 
 */
public class BinaryGroup {

	public static int toDecimal(int[][] binary) {
		int total = 0;
		int power = binary.length - 1;
		for (int[] group : binary) {
			int dec = toDec(group);
			total += dec * (Math.pow(16, power));
			power--;
		}

		return total;
	}

	private static int toDec(int[] group) {
		int total = 0;
		for (int i = 0, j = 8; i < 4; i++) {
			int x = group[i];
			total += (x * j);
			j = (j / 2);
		}
		return total;
	}
}
