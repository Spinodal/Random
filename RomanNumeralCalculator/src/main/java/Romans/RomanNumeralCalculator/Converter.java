/**
 * 
 */
package Romans.RomanNumeralCalculator;

import java.util.ArrayList;
import java.util.LinkedList;

import numerals.Numeral;
import exceptions.InvalidCharacterException;

/**
 * @author michael.wambeek
 * 
 */
public class Converter {

	/**
	 * @param input
	 * @return
	 * @throws InvalidCharacterException
	 */
	public LinkedList<Numeral> parseInput(String input)
			throws InvalidCharacterException {
		char[] characters = input.toCharArray();
		LinkedList<Numeral> parsed = new LinkedList<Numeral>();
		for (char c : characters) {
			Numeral n = Numeral.convertToNumeral(c);
			if (n != null) {
				parsed.add(n);
			} else {
				throw new InvalidCharacterException();
			}
		}
		return parsed;
	}

	
	/**
	 * @param numerals
	 * @return
	 */
	public int calculate(LinkedList<Numeral> numerals) {
		ArrayList<Integer> calcList = new ArrayList<Integer>();
		if (numerals == null || numerals.size() == 0) {
			return 0;
		} else if (numerals.size() == 1) {
			return numerals.getFirst().getValue();
		} else {
			for (int i = 0; i < numerals.size(); i++) {
				Numeral n1 = numerals.get(i);
				Numeral n2 = null;
				try {
					n2 = numerals.get(i + 1);
					if(n1.compareTo(n2) < 0){
						calcList.add(n2.getValue() - n1.getValue());
						i++;
					}
					else if(n1.compareTo(n2) >= 0){
						calcList.add(n1.getValue());
					}
				} catch (IndexOutOfBoundsException e) {
					calcList.add(n1.getValue());
				}
			}
			int total = 0;
			for(int i : calcList){
				total+= i;
			}
			return total;
		}
	}

	/**
	 * @param list
	 * @return
	 */
	public boolean validate(LinkedList<Numeral> list) {
		if (list == null) {
			return true;
		} else if (list.size() <= 1) {
			return true;
		} else {
			boolean valid = true;
			for (int i = 0; i < list.size(); i++) {
				Numeral first = list.get(i);
				if (valid) {
					Numeral second = null;
					try {
						second = list.get(i + 1);
					} catch (IndexOutOfBoundsException e) {
						break;
					}
					if (first.compareTo(second) < 0) {
						valid = first.canBeSubtracted(second);
					} else if (first.compareTo(second) == 0) {
						if (first.isRepeatable()) {
							valid = checkRepetitions(list, i);
						} else {
							return false;
						}
					}
				} else {
					break;
				}
			}
			return valid;
		}

	}

	/**
	 * @param list
	 * @param i
	 * @return
	 */
	private boolean checkRepetitions(LinkedList<Numeral> list, int i) {
		Numeral n1;
		Numeral n2;
		Numeral n3;
		Numeral n4;
		try {
			n1 = list.get(i);
			n2 = list.get(i + 1);
			n3 = list.get(i + 2);
			n4 = list.get(i + 3);
		} catch (IndexOutOfBoundsException e) {
			return true;
		}
		if ((n1.compareTo(n2) <= 0) && (n2.compareTo(n3) <= 0)
				&& (n3.compareTo(n4) <= 0)) {
			return false;
		} else {
			return true;
		}
	}
}