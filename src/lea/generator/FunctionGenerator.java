package lea.generator;

import java.util.Map;
import java.util.Map.Entry;

import lea.ArgumentInfo;
import lea.FunctionInfo;
import lea.FunctionTable;

public class FunctionGenerator {
	
	BlockGenerator bg;
	String functionHead = "", functionInstruction = "";
	NameGenerator ng;
	
	public FunctionGenerator(FunctionTable fctTable) {
		
		this.bg = new BlockGenerator();
		this.ng = new NameGenerator();
		
		
		for (Entry<String, FunctionInfo> entry : fctTable.entrySet())
		{
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
			
			
			functionHead += "\n\t}";
			
			
			/*Code*/

			
		}
		
		
	}
	
	public String generate()
	{
		
		return this.functionHead;
	}

}