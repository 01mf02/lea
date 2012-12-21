package lea.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import lea.TypeTable;
import lea.types.*;

public class TypeGenerator {
	
	TypeTable typeTable;
	
	public TypeGenerator(TypeTable typeTable){
		this.typeTable = typeTable;
	}
	
	public void generate(CodeWriter cw)
	{		
		for (Map.Entry<String, Type> entry : typeTable.entrySet())
		{
			cw.writeLine("");
			cw.writeLine("public static class " + entry.getKey() + " () {");
			cw.openBlock();
			
			cw.writeLine(entry.toString());
			cw.closeBlock();
		
		
		}
		
	}

}
