package lea.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import lea.ConstantTable;
import lea.FunctionTable;
import lea.TypeTable;

public class Generator {
	
	RestrictedWords restrictedWordList;
	ConstantGenerator cstGen;
	FunctionGenerator fctGen;
	FileWriter javaOutput;
	String nameOfClass, nameOfFile = "";
	TypeGenerator typeTable;
	File nameDir;
	SyntaxTreeGenerator varGen;
	
	public Generator(String fileName, ConstantTable cstTable, TypeTable typeTable, FunctionTable fctTable) throws IOException
	{
		this.restrictedWordList = new RestrictedWords();
		
		this.nameOfClass = fileName.substring(5, fileName.length()-4);
		
		/*Format name*/
		this.nameOfFile = this.nameOfClass + ".java";
		
		/*Création du dossier qui contiendra tous les fichiers*/
		this.nameDir = new File("data" + File.separator + this.nameOfClass);
		this.nameDir.mkdir();
		this.javaOutput = new FileWriter(this.nameDir + File.separator + this.nameOfFile);
		
		/*ConstanteTable translation*/
		this.cstGen = new ConstantGenerator(cstTable);
		
		
		/*TypeTable translation*/
		this.typeTable = new TypeGenerator(this.nameDir, typeTable);
		
		
		
		/*FunctionTable translation*/
		this.fctGen = new FunctionGenerator(fctTable);
		
		/**/this.varGen = new SyntaxTreeGenerator(fctTable);		
	}
	
	public void generate() throws IOException
	{
		String str = "";
		
		str += "public class " + this.nameOfClass + "{\n";
		str += this.cstGen.generate() +"\n";
		str += this.fctGen.generate() +"\n";
		this.typeTable.generate();
		
		str += "}";
		
		this.javaOutput.write(str);

		this.javaOutput.close();
	}
}