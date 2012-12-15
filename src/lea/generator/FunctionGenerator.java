package lea.generator;

import java.util.Map.Entry;

import lea.ArgumentInfo;
import lea.FunctionInfo;
import lea.FunctionTable;
import lea.syntax.SyntaxTree;

public class FunctionGenerator {

	BlockGenerator bg;
	String functionHead, functionInstruction, str;
	NameGenerator ng;
	String test;
	

	public FunctionGenerator(FunctionTable fctTable) {
		this.functionHead = "";
		this.functionInstruction = "";
		this.str="";
		this.test = "";
		
		this.bg = new BlockGenerator();
		this.ng = new NameGenerator();
		
		for (Entry<String, FunctionInfo> entry : fctTable.entrySet())
		{
			
			
			this.test += entry.getKey() + " " + entry.getValue().toString() + "\n\n\n";
			
			
			
			
			
			
			
			/*Return type*/
			if(entry.getValue().getOutputType() == null)
				functionHead += "\n\tvoid " + ng.generateName(entry.getKey()) + "(";
			else
				functionHead += "\n\t" + entry.getValue().getOutputType() + " " + ng.generateName(entry.getKey()) + "(";
			
			/*Arguments*/
			int argNumber = entry.getValue().getArgs().size();
			int i = 0;
			
			for(ArgumentInfo argI : entry.getValue().getArgs())
			{
				if (i == argNumber - 1)
				{
					functionHead += argI.getType() + " " + argI.getName();
				}
				else
					functionHead += argI.getType() + " " + argI.getName() + ",";
				i++;
			}
			
			functionHead += "){";
			
			
			functionHead += "\n\t}\n";
			
			
			/*Code*/
			
			


			SyntaxTree st = entry.getValue().getSyntaxTree();
			SyntaxTree node = st.getLeft();
			while (node != null) {
				// Traitement ou autre chose avec le left de st
				node = node.getLeft();
			}

			
		}
		
		
	}

	public String generate() {

		return this.functionHead;
	}

}