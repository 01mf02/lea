package lea.generator;

import java.io.FileWriter;
import java.io.IOException;

import lea.ConstantTable;
import lea.FunctionTable;
import lea.TypeTable;

public class Generator {
	
	ConstanteGenerator cstGen;
	FunctionGenerator fctGen;
	FileWriter javaOutput;
	String nameOfClass, nameOfFile = "";
	
	public Generator(String fileName, ConstantTable cstTable, TypeTable typeTable, FunctionTable fctTable) throws IOException
	{
		this.nameOfClass = fileName.substring(5, fileName.length()-4);
		
		/*Format name*/
		this.nameOfFile += this.nameOfClass + ".java";
		this.javaOutput = new FileWriter(this.nameOfFile);
		
		/*ConstanteTable translation*/
		this.cstGen = new ConstanteGenerator(cstTable);
		
		
		/*TypeTable translation*/
		
		
		
		
		/*FunctionTable translation*/
		this.fctGen = new FunctionGenerator(fctTable);
		
		
		
	}
	
	public void generate() throws IOException
	{
		String str = "";
		
		str += "public class " + this.nameOfClass + "{\n";
		str += this.cstGen.generate() +"\n";
		str += this.fctGen.generate() +"\n";
		
		str += "}";
		
		this.javaOutput.write(str);

		this.javaOutput.close();
	}
}