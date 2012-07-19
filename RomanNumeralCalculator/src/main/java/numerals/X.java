/**
 * 
 */
package numerals;

/**
 * @author michael.wambeek
 *
 */
public class X extends Numeral {
	public X(){
		this.value = 10;
	}

	@Override
	public boolean canBeSubtracted(Numeral n) {
		if(n instanceof L || n instanceof C){
			return true;
		}
		return false;
	}
}
