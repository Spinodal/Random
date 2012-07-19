/**
 * 
 */
package Romans.RomanNumeralCalculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import numerals.Numeral;

import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidCharacterException;

/**
 * @author michael.wambeek
 *
 */
public class ConverterTest {
	Converter converter = new Converter();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=InvalidCharacterException.class)
	public void testParser1() throws InvalidCharacterException {
		LinkedList<Numeral> l = converter.parseInput("safasdff");
		assertNotNull(l);
	}
	
	@Test(expected=InvalidCharacterException.class)
	public void testParser2() throws InvalidCharacterException {
		LinkedList<Numeral> l = converter.parseInput("xvivixiv");
		assertNotNull(l);
	}
	
	@Test
	public void testParser3() throws InvalidCharacterException {
		LinkedList<Numeral> l = converter.parseInput("XVIVIVIVX");
		assertNotNull(l);
	}
	
	@Test
	public void testValidate1(){
		boolean res = converter.validate(null);
		assertTrue(res);
	}
	
	@Test
	public void testValidate2(){
		boolean res = converter.validate(new LinkedList<Numeral>());
		assertTrue(res);
	}
	
	@Test(expected=InvalidCharacterException.class)
	public void testValidate3() throws InvalidCharacterException{
		Numeral[] arr = {Numeral.convertToNumeral('x')}; 
		LinkedList<Numeral> l = new LinkedList<Numeral>(Arrays.asList(arr));
		boolean res = converter.validate(l);
		assertTrue(res);
	}
	
	@Test
	public void testValidate4() throws InvalidCharacterException{
		Numeral[] arr = {Numeral.convertToNumeral('X')}; 
		LinkedList<Numeral> l = new LinkedList<Numeral>(Arrays.asList(arr));
		boolean res = converter.validate(l);
		assertTrue(res);
	}
	
	@Test
	public void testValidate5() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		Numeral n = Numeral.convertToNumeral('X');
		Numeral n2 = Numeral.convertToNumeral('I');
		l.add(n);
		l.add(n2);
		boolean res = converter.validate(l);
		assertTrue(res);
	}
	
	@Test
	public void testValidate6() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		l.add(Numeral.convertToNumeral('M'));
		l.add(Numeral.convertToNumeral('D'));
		l.add(Numeral.convertToNumeral('C'));
		l.add(Numeral.convertToNumeral('L'));
		l.add(Numeral.convertToNumeral('X'));
		l.add(Numeral.convertToNumeral('V'));
		l.add(Numeral.convertToNumeral('I'));
		boolean res = converter.validate(l);
		assertTrue(res);
	}
	
	@Test
	public void testValidate7() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('V'));
		boolean res = converter.validate(l);
		assertFalse(res);
	}
	
	@Test
	public void testValidate8() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		l.add(Numeral.convertToNumeral('M'));
		l.add(Numeral.convertToNumeral('M'));
		l.add(Numeral.convertToNumeral('X'));
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('I'));
		boolean res = converter.validate(l);
		assertTrue(res);
	}
	
	@Test
	public void testValidate9() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		l.add(Numeral.convertToNumeral('M'));
		l.add(Numeral.convertToNumeral('M'));
		l.add(Numeral.convertToNumeral('C'));
		l.add(Numeral.convertToNumeral('M'));
		l.add(Numeral.convertToNumeral('X'));
		l.add(Numeral.convertToNumeral('C'));
		l.add(Numeral.convertToNumeral('V'));
		l.add(Numeral.convertToNumeral('I'));
		l.add(Numeral.convertToNumeral('I'));
		boolean res = converter.validate(l);
		assertTrue(res);
	}
	
	@Test
	public void testValidate10() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		l.add(Numeral.convertToNumeral('X'));
		l.add(Numeral.convertToNumeral('V'));
		l.add(Numeral.convertToNumeral('V'));
		boolean res = converter.validate(l);
		assertFalse(res);
	}
	
	@Test
	public void testCalculate1() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		l.add(Numeral.convertToNumeral('X'));
		int res = converter.calculate(l);
		assertEquals(10, res);
	}
	
	@Test
	public void testCalculate2() throws InvalidCharacterException{
		
		int res = converter.calculate(null);
		assertEquals(0, res);
	}
	
	@Test
	public void testCalculate3() throws InvalidCharacterException{
		int res = converter.calculate(new LinkedList<Numeral>());
		assertEquals(0, res);
	}
	
	@Test
	public void testCalculate4() throws InvalidCharacterException{
		LinkedList<Numeral> l = new LinkedList<Numeral>();
		l.add(Numeral.convertToNumeral('M'));
		l.add(Numeral.convertToNumeral('D'));
		l.add(Numeral.convertToNumeral('I'));
		int res = converter.calculate(l);
		assertEquals(1501, res);
	}
	

}
