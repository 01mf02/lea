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
	SyntaxTreeGenerator stGen;
	
	public Generator(File nameDir, String nameOfClass, ConstantTable cstTable, TypeTable typeTable, FunctionTable fctTable) throws IOException
	{
		this.nameOfClass = nameOfClass;
		
		/*Format name*/
		this.nameOfFile = this.nameOfClass + ".java";
		
		this.nameDir = nameDir;
		
		/*ConstantTable translation*/
		this.cstGen = new ConstantGenerator(cstTable);
		
		/*TypeTable translation*/
		this.typeTable = new TypeGenerator(this.nameDir, typeTable);	
		
		/*FunctionTable translation*/
		this.fctGen = new FunctionGenerator(fctTable);
		
		/**/
		this.stGen = new SyntaxTreeGenerator(fctTable);		
	}
	
	public void generate() throws IOException
	{
		CodeWriter cw = new CodeWriter();
		cw.writeLine("public class " + this.nameOfClass);
		cw.openBlock();
		this.cstGen.generate(cw) ;
		cw.closeBlock();
		
		this.fctGen.generate(cw);
		/*if (this.typeTable.generate() != null)
				str += this.typeTable.generate();
		
		str += "}";
		
		FileWriter javaOutput = new FileWriter(this.nameDir + File.separator + this.nameOfFile);
		javaOutput.write(str);
		javaOutput.close();*/
		
		cw.saveFile(this.nameDir + File.separator + this.nameOfFile);

	}
}