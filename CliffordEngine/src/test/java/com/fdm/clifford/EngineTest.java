/**
 * 
 */
package com.fdm.clifford;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import com.fdm.exceptions.IllegalInputException;

/**
 * @author michael.wambeek
 *
 */
public class EngineTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() throws IllegalInputException {
		BigInteger res = Engine.run("0 2 0 2 2");
		assertEquals(new BigInteger("4"), res);
	}

	@Test
	public void test2() throws IllegalInputException {
		BigInteger res = Engine.run("0 5 0 3 3");
		assertEquals(new BigInteger("2"), res);
	}
	@Test
	public void test3() throws IllegalInputException {
		BigInteger res = Engine.run("0 10 0 10 4");
		assertEquals(new BigInteger("100"),res);
	}
	@Test
	public void test4() throws IllegalInputException {
		BigInteger res = Engine.run("0 10 0 5 5");
		assertEquals(new BigInteger("2"),res);
	}
	
	@Test
	public void test5() throws IllegalInputException {
		BigInteger res = Engine.run("0 60 0 10 3 0 180 0 3 5 4 0 4 2");
		assertEquals(new BigInteger("3004"),res);
	}
	
	@Test(expected=IllegalInputException.class)
	public void test6() throws IllegalInputException {
		Engine.run("0 0 0 0 5");
		fail("exception should have been thrown");
	}
	
	@Test(expected=IllegalInputException.class)
	public void test7() throws IllegalInputException {
		Engine.run("0 adsdasd");
		fail("exception should have been thrown");
	}
	
	@Test(expected=IllegalInputException.class)
	public void test8() throws IllegalInputException {
		Engine.run("0 1 0 5 6");
		fail("exception should have been thrown");
	}
	
	@Test(expected=IllegalInputException.class)
	public void test9() throws IllegalInputException {
		Engine.run("0");
		fail("exception should have been thrown");
	}
	
	@Test(expected=IllegalInputException.class)
	public void test10() throws IllegalInputException {
		Engine.run("0 s");
		fail("exception should have been thrown");
	}
	
	@Test(expected=IllegalInputException.class)
	public void test11() throws IllegalInputException {
		Engine.run("");
		fail("exception should have been thrown");
	}
}
