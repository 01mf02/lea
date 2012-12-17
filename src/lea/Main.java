package lea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import generated.*;
import lea.generator.*;

public class Main {
	public static int numID = 0;
	
	public static int main(String[] args) throws IOException {
		System.out.println("Lea compiler initialized.");

		for (int i = 0; i < args.length; i++) {
			System.out.println("\n\nReading file " + args[i] + " ...");
			
			LeaParser parser = parseFile(args[i]);

			if(parser != null)
			{
				FunctionTable fctTable = parser.getFunctionTable();
				ConstantTable constTable = parser.getConstantTable();
				TypeTable typeTable = parser.getTypeTable();
	
				System.out.println("\nConstant table:");
				System.out.println(constTable);
	
				System.out.println("Type table:");
				System.out.println(typeTable);
	
				System.out.println("Function table:");
				System.out.println(fctTable);
	
				fctTable.saveDotToDir(args[i].replace(".lea",""));
	
				if (!parser.hasCompileErrors()) 
				{
					
					Generator generator = new Generator(args[i], constTable, typeTable, fctTable);
					generator.generate();
	
					
				}
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
