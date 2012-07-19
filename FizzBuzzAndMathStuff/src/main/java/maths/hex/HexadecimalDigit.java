/**
 * 
 */
package maths.hex;

/**
 * @author michael.wambeek
 * 
 */
public class HexadecimalDigit {

	public static int[] getBinaryValue(char digit) {
		int[] binary = new int[4];
		int val = 0;
		if (Character.isDigit(digit)) {
			val = Character.getNumericValue(digit);
		} else {
			switch (digit) {
			case 'A':
				val = 10;
				break;
			case 'B':
				val = 11;
				break;
			case 'C':
				val = 12;
				break;
			case 'D':
				val = 13;
				break;
			case 'E':
				val = 14;
				break;
			case 'F':
				val = 15;
				break;
			}
		}

		for (int i = 0, j = 8; j > 0; i++, j = j / 2) {
			if (val - j >= 0) {
				binary[i] = 1;
				val = val - j;
			} else {
				binary[i] = 0;
			}
		}
		return binary;
	}
}
