package lea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// TODO: set up type and function table here
			// add functions like writeln() and read() to function table

			System.out.println("Léa compiler initialized.");

			FileReader file;
			try {
				file = new FileReader(args[0]);
			} catch (FileNotFoundException e) {
				System.err.println("File not found!");
			}

			// TODO: lexing here

			System.out.println("Lexing finished.");

			// TODO: parsing here

			System.out.println("Parsing finished.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
