package lea.generator;

import java.io.File;
import java.io.IOException;

import lea.FunctionTable;
import lea.TypeTable;
import lea.types.Type;

public class Generator {

	final File directory;
	final String className, fileName;
	final TypeGenerator typeGen;
	final FunctionGenerator fctGen;

	public Generator(File directory, String className, TypeTable typeTable,
			FunctionTable fctTable) throws IOException {
		this.directory = directory;
		this.className = className;
		this.fileName = this.className + ".java";

		this.typeGen = new TypeGenerator(typeTable);
		this.fctGen = new FunctionGenerator(fctTable);

	}

	public boolean generate() throws IOException {
		CodeWriter cw = new CodeWriter();
		cw.writeLine("import java.util.*;");
		cw.writeLine("");
		cw.writeLine("public class " + this.className);
		cw.openBlock();

		// scanner for command line input
		cw.writeLine("static Scanner scanner = new Scanner(System.in);");

		this.typeGen.generate(cw);

		boolean success = this.fctGen.generate(cw);
		if (!success)
			return false;

		cw.closeBlock();

		cw.saveFile(this.directory + File.separator + this.fileName);

		return true;
	}

	public String getFileName() {
		return this.fileName;
	}

	static public String generateName(String id) {
		return "lea_" + id;
	}

	static public String generateDeclaration(String name, Type type) {
		String decl = type.toJava() + " " + name;
		if (type.requiresInitialisation())
			decl += " = new " + type.toJava() + "()";
		return decl + ";";
	}
}