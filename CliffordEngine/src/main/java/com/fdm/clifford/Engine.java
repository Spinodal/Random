/**
 * 
 */
package com.fdm.clifford;

import gui.CommandLine;
import gui.Gui;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.fdm.exceptions.IllegalInputException;
import com.fdm.items.Add;
import com.fdm.items.Argument;
import com.fdm.items.Divide;
import com.fdm.items.Multiply;
import com.fdm.items.Operator;
import com.fdm.items.Pop;
import com.fdm.items.Push;
import com.fdm.items.Subtract;

/**
 * @author michael.wambeek
 * 
 */
public class Engine {

	public static void main(String[] args) {
		String arg = null;
		if (args.length > 0) {
			arg = args[0];
		}

		if (arg != null) {
			if (args[0].equals("g")) {
				new Gui();
			}
		}
		else{
			CommandLine.run();				
		}
	}

	/**
	 * @param calcString
	 * @return result
	 * @throws IllegalInputException
	 */
	public static BigInteger run(String calcString)
			throws IllegalInputException {
		try {
			Engine e = new Engine();
			List<Operator> calcList = e.parse(calcString);
			BigInteger result = e.calculate(calcList);
			return result;
		} catch (ArithmeticException e) {
			throw new IllegalInputException(e.getMessage());
		}
	}

	/**
	 * @param calcString
	 * @return List of processing instructions
	 * @throws IllegalInputException
	 */
	private List<Operator> parse(String calcString)
			throws IllegalInputException {
		calcString = calcString.trim();
		String[] divided = calcString.split(" ");

		ArrayList<Operator> processed = new ArrayList<Operator>();
		if (calcString.isEmpty()) {
			return processed;
		}

		for (int i = 0; i < divided.length; i++) {
			try {
				switch (Integer.parseInt(divided[i])) {
				case 0: // push
					i++; // get position of argument to push
					Argument a = new Argument(new BigInteger(divided[i]));
					processed.add(new Push(a));
					break;

				case 1:// pop
					processed.add(new Pop());
					break;

				case 2:// add
					processed.add(new Add());
					break;

				case 3:// subtract
					processed.add(new Subtract());
					break;

				case 4:// multiply
					processed.add(new Multiply());
					break;

				case 5:// divide
					processed.add(new Divide());
					break;

				default:// other chars
					throw new IllegalInputException("Illegal Input at number: "
							+ (i + 1) + " \n" + "Command numbers must be 0-5");

				}
			} catch (NumberFormatException e) {
				throw new IllegalInputException(
						"Illegal character at position: " + (i + 1) + " \n"
								+ "Only Integers are allowed");
			} catch (IndexOutOfBoundsException e) {
				throw new IllegalInputException("0 must have an argument");
			}
		}
		return processed;
	}

	/**
	 * @param calcList
	 * @return result
	 */
	private BigInteger calculate(List<Operator> calcList) {
		Stack<Argument> stack = new Stack<Argument>();
		for (Operator operator : calcList) {
			operator.process(stack);
		}
		if (!stack.empty()) {
			return stack.pop().getValue();
		}
		return new BigInteger("0");
	}
}
