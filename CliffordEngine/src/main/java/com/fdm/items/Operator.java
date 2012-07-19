/**
 * 
 */
package com.fdm.items;

import java.util.Stack;

/**
 * @author michael.wambeek
 *
 */
public abstract class Operator {

	/**
	 * @param stack
	 */
	public abstract void process(Stack<Argument> stack);

}
