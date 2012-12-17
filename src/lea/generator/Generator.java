package lea.generator;

import java.io.File;
import java.io.FileWriter;
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
		String str = "";
		
		str += "public class " + this.nameOfClass + "{\n";
		str += this.cstGen.generate() +"\n";
		str += this.fctGen.generate() +"\n";
		str += this.typeTable.generate();
		
		str += "}";
		
		FileWriter javaOutput = new FileWriter(this.nameDir + File.separator + this.nameOfFile);
		javaOutput.write(str);
		javaOutput.close();
	}
}