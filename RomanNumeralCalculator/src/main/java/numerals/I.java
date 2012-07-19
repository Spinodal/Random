/**
 * 
 */
package numerals;

/**
 * @author michael.wambeek
 *
 */
public class I extends Numeral {
	public I(){
		this.value = 1;
	}

	@Override
	public boolean canBeSubtracted(Numeral n) {
		if(n instanceof V || n instanceof X){
			return true;
		}
		return false;
	}
}
