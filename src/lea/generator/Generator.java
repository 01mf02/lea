package lea.generator;

import java.io.File;
import java.io.IOException;

import lea.ConstantTable;
import lea.FunctionTable;
import lea.TypeTable;

public class Generator {	
	
	ConstantGenerator cstGen;
	FunctionGenerator fctGen;
	String nameOfClass, nameOfFile = "";
	TypeGenerator typeTable;
	File nameDir;
	
	public Generator(File nameDir, String nameOfClass, ConstantTable cstTable, TypeTable typeTable, FunctionTable fctTable) throws IOException
	{
		this.nameOfClass = nameOfClass;
		/*Format name*/
		this.nameOfFile = this.nameOfClass + ".java";
		this.nameDir = nameDir;
		
		
		this.cstGen = new ConstantGenerator(cstTable);
		
		this.typeTable = new TypeGenerator(typeTable);	
		
		this.fctGen = new FunctionGenerator(fctTable);
		
	}
	
	public void generate() throws IOException
	{
		CodeWriter cw = new CodeWriter();
		cw.writeLine("public class " + this.nameOfClass);
		cw.openBlock();
		this.cstGen.generate(cw);
		this.typeTable.generate(cw);
		this.fctGen.generate(cw);
		cw.closeBlock();
		
		cw.saveFile(this.nameDir + File.separator + this.nameOfFile);

	}
}