/**
 * 
 */
package exceptions;

/**
 * @author michael.wambeek
 *
 */
public class InvalidCharacterException extends Exception {
	private static final long serialVersionUID = 3187286478068945406L;

	@Override
	public String getMessage(){
		return "Invalid Character";
	}
}
