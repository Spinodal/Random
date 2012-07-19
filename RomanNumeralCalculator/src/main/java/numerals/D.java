/**
 * 
 */
package numerals;

/**
 * @author michael.wambeek
 *
 */
public class D extends Numeral {
	public D(){
		this.value = 500;
	}
	
	@Override
	public boolean isRepeatable() {
		return false;
	}
}
