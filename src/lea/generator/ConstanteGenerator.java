package lea.generator;

import java.io.IOException;
import java.util.Map;

import lea.ConstantTable;
import lea.constants.Constant;

public class ConstanteGenerator {

	ConstantTable cstTable;
	NameGenerator ng;
	FileWriterT fw;
	
	public ConstanteGenerator(ConstantTable cstTable) throws IOException {
		this.cstTable = cstTable;
		this.ng = new NameGenerator();
		this.fw = new FileWriterT();    /*Truc pour mes tests... Ne sert pas dans la code originel*/
	}
	
	public String generate() throws IOException
	{
		String str = "";
		
		
		
		for (Map.Entry<String, Constant> entry : cstTable.entrySet()) {
			/*int, String, float*/
			if ((entry.getValue().getType().toString() == "int")||
				(entry.getValue().getType().toString() == "float")||
				(entry.getValue().getType().toString() =="String"))
			{
				str += "public final " + ng.generateName(entry.getKey()) + " " 
					   + entry.getValue().getType() + " = " + entry.getValue().toString() + ";\n";
			}
			/*List*/
			else if (entry.getValue().getType().toString() == "List")
			{
				str += "public final " + ng.generateName(entry.getKey()) + " <" + entry.getValue().getType().getType() + ">"
						   + entry.getValue().getType() + " = " + entry.getValue().toString() + ";\n";
			}
			/*tuple*/
			
			
			
			fw.generate(entry.getValue().getType().toString());
		}

		
		return str;
	}
}