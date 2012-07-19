/**
 * 
 */
package maths.fizzbuzz;

/**
 * @author michael.wambeek
 *
 */
public class FizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=1; i<=100; i++){
			System.out.print(i + ":");
			if(i%3 == 0){
				System.out.print("Fizz");
			}
			if(i%5 == 0){
				System.out.print("Buzz");
			}
			System.out.print("\n");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
