package lea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import generated.*;
import lea.generator.*;
import lea.syntax.*;

public class Main {
	
	public static int main(String[] args) {
		System.out.println("Léa compiler initialized.");

		for (int i = 0; i < args.length; i++) {
			System.out.println("Reading file " + args[i] + " ...");

			LeaParser parser = parseFile(args[i]);

			FunctionTable fctTable = parser.getFunctionTable();
			ConstantTable constTable = parser.getConstantTable();
			TypeTable typeTable = parser.getTypeTable();

			System.out.println("Constant table:");
			System.out.println(constTable);

			System.out.println("Type table:");
			System.out.println(typeTable);

			/*System.out.println("Function table:");
			System.out.println(fctTable);*/

			//fctTable.saveDotToDir("data");

			if (!parser.hasCompileErrors()) {
				Generator generator = new Generator(constTable, typeTable, fctTable);
			}
		}

		return 0;
	}

	public static LeaParser parseFile(String filename) {
		FileReader file = null;
		try {
			file = new FileReader(filename);
		} catch (FileNotFoundException e) {
			System.err.println("File '" + filename + "' not found!");
		}

		LeaLexer lexer = new LeaLexer(file);
		LeaParser parser = new LeaParser(lexer);

		try {
			System.out.println("Starting parsing ...");
			parser.parse();
		} catch (Exception e) {
			System.out.println("Exception caught during parsing ...");
			e.printStackTrace();
			return null;
		}

		System.out.println("Parsing completed!");
		return parser;
	}
}
