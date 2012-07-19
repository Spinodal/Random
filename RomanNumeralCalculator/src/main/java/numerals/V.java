/**
 * 
 */
package numerals;

/**
 * @author michael.wambeek
 *
 */
public class V extends Numeral {
	public V(){
		this.value = 5;
	}
	
	@Override
	public boolean isRepeatable() {
		return false;
	}
}
