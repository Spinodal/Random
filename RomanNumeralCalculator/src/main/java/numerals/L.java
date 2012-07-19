/**
 * 
 */
package numerals;

/**
 * @author michael.wambeek
 *
 */
public class L extends Numeral {
	public L(){
		this.value = 50;
	}
	
	@Override
	public boolean isRepeatable() {
		return false;
	}
}
