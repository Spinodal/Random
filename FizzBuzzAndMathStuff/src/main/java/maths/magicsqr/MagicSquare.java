/**
 * 
 */
package maths.magicsqr;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author michael.wambeek
 * 
 */
public class MagicSquare {
	private static int[][] grid;
	
	private static int currentNumber;
	private static int maxNumber;
	private static int oldx;
	private static int oldy;

	private static int printDelay;
	private static Stack<Integer> numbers;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter grid size:\n>>:");
			try {
				Integer input = Integer.parseInt(scanner.nextLine());
				if (input % 2 == 1) {
					oddFill(input, 200);
				} else {
					doubleFill(input, 200);
				}
				verify(input);
				break;
			} catch (NumberFormatException e) {
				System.err.println("Invalid Number!!");
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		System.out.println("Program complete.");
	}

	/**
	 * @param size
	 * @throws IOException
	 */
	private static void verify(int size) throws IOException {
		int count = 0;
		for (int y = 0; y < size; y++) {
			int rowCount = 0;
			for (int x = 0; x < size; x++) {
				rowCount += grid[y][x];
			}
			if (count == 0) {
				count = rowCount;
			} else if (count != rowCount) {
				throw new IOException() {
					private static final long serialVersionUID = 1280789915773488598L;

					@Override
					public String getMessage() {
						return "Program Failed!!\nMagic Constant is not magic  :`(";
					}
				};
			}
		}
		System.out.println("Magic Constant = " + count);
	}

	/**
	 * @param size
	 * @param sleepTime
	 * @throws IOException
	 */
	public static void oddFill(final int size, int printDelay)
			throws IOException {
		if (size % 2 != 1) {
			throw new IOException() {
				private static final long serialVersionUID = 4190040613320182907L;

				@Override
				public String getMessage() {
					return "Illegal Size";
				}
			};
		}

		setUp(size, printDelay);

		int startX = ((size + 1) / 2) - 1;

		printState();
		oldx = startX;
		int newx = 0;
		int newy = 0;
		grid[oldy][oldx] = currentNumber;
		currentNumber++;
		printState();
		while (currentNumber <= maxNumber) {
			while (true) {
				boolean flag = false;
				newx = (oldx + 1) % size;
				newy = (oldy - 1) % size;
				newy = (newy < 0) ? (newy + size) : newy;
				if (grid[newy][newx] == 0) {
					grid[newy][newx] = currentNumber;
					flag = true;
				} else {
					newx = oldx;
					newy = (oldy + 1) % size;
					if (grid[newy][newx] == 0) {
						grid[newy][newx] = currentNumber;
						flag = true;
					}
				}
				oldx = newx;
				oldy = newy;
				if (flag) {
					break;
				}
			}
			currentNumber++;
			printState();
		}

	}

	/**
	 * @param size
	 * @param sleepTime
	 * @throws IOException
	 */
	public static void doubleFill(final int size, int printDelay)
			throws IOException {
		if (size % 4 != 0) {
			throw new IOException() {
				private static final long serialVersionUID = 1334159307043731902L;

				@Override
				public String getMessage() {
					return "Illegal Size";
				}
			};
		}

		setUp(size, printDelay);

		int miniSize = size / 4;
		int centerSize = miniSize * 2;

		// fill top left mini square
		for (int y = 0; y < miniSize; y++) {
			for (int x = 0; x < miniSize; x++) {
				setSeqNumber(size, x, y);
			}
		}

		// fill top right mini square
		for (int y = 0; y < miniSize; y++) {
			for (int x = (size - 1); x > (size - miniSize - 1); x--) {
				setSeqNumber(size, x, y);
			}
		}

		// fill bottom left mini square
		for (int y = (size - 1); y > (size - miniSize - 1); y--) {
			for (int x = 0; x < miniSize; x++) {
				setSeqNumber(size, x, y);
			}
		}

		// fill bottom right mini square

		for (int y = (size - 1); y > (size - miniSize - 1); y--) {
			for (int x = (size - 1); x > (size - miniSize - 1); x--) {
				setSeqNumber(size, x, y);
			}
		}

		// fill center square
		for (int y = miniSize; y < (miniSize + centerSize); y++) {
			for (int x = miniSize; x < (miniSize + centerSize); x++) {
				setSeqNumber(size, x, y);
			}
		}

		// fill remaining
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (grid[y][x] == 0) {
					grid[y][x] = numbers.pop();
					printState();
				}
			}
		}
	}

	private static void setSeqNumber(int size, int x, int y) {
		int number = (y * size) + (x + 1);
		grid[y][x] = number;
		numbers.remove(new Integer(number));
		printState();
	}

	/**
	 * @param size
	 */
	private static void setUp(int size, int printDelay) {
		grid = new int[size][size];
		currentNumber = 1;
		maxNumber = size * size;
		oldx = 0;
		oldy = 0;

		numbers = new Stack<Integer>();
		for (int i = 1; i <= maxNumber; i++) {
			numbers.push(i);
		}
		MagicSquare.printDelay = printDelay;
	}

	/**
	 * @param grid
	 * @param sleepTime
	 */
	public static void printState() {
		System.out
				.println("\n==================================================\n");
		for (int[] row : grid) {
			for (int square : row) {
				System.out.print("\t" + square);
			}
			// System.out.println("\n");
			System.out.println();
		}
		try {
			Thread.sleep(printDelay);
		} catch (InterruptedException e) {
			System.out.println("interupted");
		}
	}

}
