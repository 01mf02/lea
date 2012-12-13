package lea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import generated.*;
import lea.generator.*;
import lea.syntax.*;

public class Main {
	
	private static boolean hasCompileErrors = false;
	private static LeaLexer lexer;

	/**
	 * @param args
	 */
	public static int main(String[] args) {
		System.out.println("Léa compiler initialized.");

		LeaParser parser = parseFile(args[0]);

		FunctionTable fctTable = parser.getFunctionTable();
		ConstantTable constTable = parser.getConstantTable();
		TypeTable typeTable = parser.getTypeTable();

		System.out.println("Constant table:");
		System.out.println(constTable);

		System.out.println("Type table:");
		System.out.println(typeTable);

		System.out.println("Function table:");
		System.out.println(fctTable);

		fctTable.saveDotToDir("data");

		if (!hasCompileErrors) {
			Generator generator = new Generator(constTable, typeTable, fctTable);
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

		lexer = new LeaLexer(file);
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

	public static void printError(String message, int level) {
		String prefix = "";

		switch (level) {
		case 0:
			prefix += "Warning";
			break;
		case 1:
			prefix += "Error";
			hasCompileErrors = true;
			break;
		case 2:
			prefix += "Fatal error";
			hasCompileErrors = true;
			break;
		default:
			break;
		}

		if (level >= 0 && level <= 2)
			prefix += " at line " + lexer.getLine() + ", column "
					+ lexer.getColumn() + ": ";

		System.out.println(prefix + message);
	}
}
