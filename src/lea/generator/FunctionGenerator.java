package lea.generator;

import java.io.IOException;
import java.util.Map.Entry;

import lea.ArgumentInfo;
import lea.FunctionInfo;
import lea.FunctionTable;
import lea.syntax.Instruction;

public class FunctionGenerator {

	FunctionTable fctTable;

	public FunctionGenerator(FunctionTable fctTable) {
		this.fctTable = fctTable;
	}

	public void generate(CodeWriter cw) throws IOException {

		String functionHead, functionBody;
		NameGenerator ng;

		functionHead = "";
		functionBody = "";

		ng = new NameGenerator();

		for (Entry<String, FunctionInfo> entry : fctTable.entrySet()) {
			if (entry.getKey().equals("main"))
				functionHead += "\tpublic static int main(String[] args";
			else {
				/* Return type */
				if (entry.getValue().getOutputType() == null)
					functionHead += "\n\tvoid "
							+ ng.generateName(entry.getKey()) + "(";
				else
					functionHead += "\n\t" + entry.getValue().getOutputType()
							+ " " + ng.generateName(entry.getKey()) + "(";

				/* Arguments */
				int argNumber = entry.getValue().getArgs().size();
				int i = 0;

				for (ArgumentInfo argI : entry.getValue().getArgs()) {
					if (i == argNumber - 1) {
						functionHead += argI.getType() + " " + argI.getName();
					} else
						functionHead += argI.getType() + " " + argI.getName()
								+ ",";
					i++;
				}
			}

			functionHead += "){\n";
			
			for (Entry<String, FunctionInfo> function : fctTable.entrySet()) {
				Instruction root = function.getValue().getSyntaxTree();
				root.toJava(cw);
			}
		}
		
		cw.writeLine("\n\t" + functionHead + functionBody + "\n\t}\n");
	}

}