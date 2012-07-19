/**
 * 
 */
package exercises.elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author michael.wambeek
 * 
 */
public final class PeriodicTable {
	// table - [rows][cols]
	private Element[][] table;
	private static final String FILE = "src/main/resources/exercises/periodensystem.csv";

	public PeriodicTable() {
		table = new Element[7][18];
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws IOException
	 */
	private void readFile() throws IOException {
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(FILE);
			br = new BufferedReader(fr);
			String line;

			// Example of one text line: 79,Gold (Aurum),Au,11,6
			while (br.ready()) {
				line = br.readLine();
				String[] data = line.split(",");
				int row = Integer.parseInt(data[4]) -1;
				int col = Integer.parseInt(data[3]) -1;
				String name = data[1];
				String symb = data[2];
				int atom = Integer.parseInt(data[0]);
				table[row][col] = new Element(name, symb, atom);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}

	}

	public void print() {
		for(int i=0; i < table.length; i++){
			for(int j=0; j < table[i].length; j++){
				Element el = table[i][j];
				if(el != null){
					System.out.println("("+i+","+j+")" + el.toString());
				}
			}
		}
	}
	
	public void display(){
		new GUI(table);
	}
}
