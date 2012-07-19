/**
 * 
 */
package com.fdm.items;

import java.util.Stack;

/**
 * @author michael.wambeek
 * 
 */
public class Divide extends Operator {

	@Override
	public void process(Stack<Argument> stack) {
		if (stack.size() >= 2) {
			Argument a1 = stack.pop();
			Argument a2 = stack.pop();

			stack.push(a2.divide(a1));
		}
	}

}
