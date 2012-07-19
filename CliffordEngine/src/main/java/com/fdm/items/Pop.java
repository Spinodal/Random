/**
 * 
 */
package com.fdm.items;

import java.util.Stack;

/**
 * @author michael.wambeek
 *
 */
public class Pop extends Operator {

	@Override
	public void process(Stack<Argument> stack) {
		if(!stack.empty()){
			stack.pop();
		}
	}

}
