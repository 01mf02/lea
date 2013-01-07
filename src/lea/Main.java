package lea;

import generated.LeaLexer;
import generated.LeaParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lea.generator.Generator;

public class Main {
	public static int main(String[] args) throws IOException {
		System.out.println("Lea compiler initialized.");

		for (int i = 0; i < args.length; i++) {
			System.out.println("\n\nReading file " + args[i] + " ...");

			LeaParser parser = parseFile(args[i]);

			if (parser == null)
				continue;

			FunctionTable fctTable = parser.getFunctionTable();
			ConstantTable constTable = parser.getConstantTable();
			TypeTable typeTable = parser.getTypeTable();

			System.out.println("\n");

			System.out.println("Constant table:");
			System.out.println(constTable);

			System.out.println("Type table:");
			System.out.println(typeTable);

			System.out.println("Function table:");
			System.out.println(fctTable);

			System.out.println("\n");

			File dotDir = new File(args[i].replace(".lea", ""));
			dotDir.mkdir();

			fctTable.saveDotToDir(dotDir.getPath());

			if (parser.hasCompileErrors())
				continue;

			File javaDir = new File(args[i]).getParentFile();
			String className = dotDir.getName();

			Generator generator = new Generator(javaDir, className, typeTable,
					fctTable);
			boolean success = generator.generate();

			if (success)
				System.out.println("Java file " + generator.getFileName()
						+ " successfully created!");
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
