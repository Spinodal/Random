/**
 * 
 */
package numerals;

import exceptions.InvalidCharacterException;

/**
 * @author michael.wambeek
 * 
 */
public abstract class Numeral implements Comparable<Numeral> {

	int value;

	/**
	 * @return
	 */
	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Numeral numeral) {
		return this.getValue() - numeral.getValue();
	}

	/**
	 * @param n
	 * @return
	 */
	public boolean canBeSubtracted(Numeral n) {
		return false;
	}

	public static Numeral convertToNumeral(char c) throws InvalidCharacterException {
		switch (c) {
		case 'I':
			return new I();
		case 'V':
			return new V();
		case 'X':
			return new X();
		case 'L':
			return new L();
		case 'C':
			return new C();
		case 'D':
			return new D();
		case 'M':
			return new M();
		default:
			throw new InvalidCharacterException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numeral other = (Numeral) obj;
		if (value != other.value)
			return false;
		return true;
	}

	public boolean isRepeatable() {
		return true;
	}
}
