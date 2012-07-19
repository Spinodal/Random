/**
 * 
 */
package numerals;

/**
 * @author michael.wambeek
 *
 */
public class C extends Numeral {
	public C(){
		this.value = 100;
	}

	@Override
	public boolean canBeSubtracted(Numeral n) {
		if(n instanceof D || n instanceof M){
			return true;
		}
		return false;
	}
}
