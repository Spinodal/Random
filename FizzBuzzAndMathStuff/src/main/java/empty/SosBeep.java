/**
 * 
 */
package empty;

import java.awt.Toolkit;

/**
 * @author michael.wambeek
 * 
 */
public class SosBeep {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			
			//S
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(200);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(200);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(200);

			/*space*/
			Thread.sleep(600);

			//O
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(400);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(400);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(400);

			/*space*/
			Thread.sleep(600);

			//S
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(200);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(200);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(200);

			/*gap*/
			Thread.sleep(1000);
		}
	}

}
