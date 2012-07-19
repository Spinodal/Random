/**
 * 
 */
package com.fdm.items;

import java.util.Stack;

/**
 * @author michael.wambeek
 *
 */
public class Push extends Operator {
	Argument argument;

	/**
	 * @param a
	 */
	public Push(Argument a) {
		argument = a;
	}

	@Override
	public void process(Stack<Argument> stack) {
		stack.push(argument);
	}

}
