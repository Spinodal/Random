/**
 * 
 */
package com.fdm.exceptions;

/**
 * @author michael.wambeek
 *
 */
public class IllegalInputException extends Exception {
	private String message;
	private static final long serialVersionUID = -8438285969681642570L;
	
	public IllegalInputException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
