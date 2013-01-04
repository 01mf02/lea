package lea.generator;

import java.io.File;
import java.io.IOException;

import lea.ConstantTable;
import lea.FunctionTable;
import lea.TypeTable;
import lea.types.Type;

public class Generator {

	FunctionGenerator fctGen;
	String nameOfClass, nameOfFile = "";
	TypeGenerator typeTable;
	File nameDir;

	public Generator(File nameDir, String nameOfClass, ConstantTable cstTable,
			TypeTable typeTable, FunctionTable fctTable) throws IOException {
		this.nameOfClass = nameOfClass;
		/* Format name */
		this.nameOfFile = this.nameOfClass + ".java";
		this.nameDir = nameDir;

		this.typeTable = new TypeGenerator(typeTable);

		this.fctGen = new FunctionGenerator(fctTable);

	}

	public void generate() throws IOException {
		CodeWriter cw = new CodeWriter();
		cw.writeLine("import java.util.*;");
		cw.writeLine("");
		cw.writeLine("public class " + this.nameOfClass);
		cw.openBlock();
		this.typeTable.generate(cw);
		this.fctGen.generate(cw);
		cw.closeBlock();

		cw.saveFile(this.nameDir + File.separator + this.nameOfFile);
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