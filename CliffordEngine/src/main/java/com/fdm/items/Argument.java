/**
 * 
 */
package com.fdm.items;

import java.math.BigInteger;


/**
 * @author michael.wambeek
 * 
 * Immutable class. 
 */
public final class Argument{
	private final BigInteger value;

	/**
	 * @param value
	 */
	public Argument(BigInteger value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public BigInteger getValue() {
		return value;
	}
	
	/**
	 * @param augend
	 * @return
	 */
	public Argument add(Argument augend){
		BigInteger val = augend.getValue();
		return new Argument(value.add(val));
	}
	
	/**
	 * @param subtrahend
	 * @return
	 */
	public Argument subtract(Argument subtrahend){
		BigInteger val = subtrahend.getValue();
		return new Argument(value.subtract(val));
	}
	
	/**
	 * @param multiplicand
	 * @return
	 */
	public Argument multiply(Argument multiplicand){
		BigInteger val = multiplicand.getValue();
		return new Argument(value.multiply(val));
	}
	
	/**
	 * @param divisor
	 * @return
	 */
	public Argument divide(Argument divisor){
		BigInteger val = divisor.getValue();
		return new Argument(value.divide(val));
	}
}
