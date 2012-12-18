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

		NameGenerator ng;

		ng = new NameGenerator();

		for (Entry<String, FunctionInfo> entry : fctTable.entrySet()) {
			
			cw.writeLine("");
			if (entry.getKey().equals("main"))
				cw.writeLine("public static int main(String[] args)");
			else {
				String return_type = "";
				if (entry.getValue().getOutputType() == null)
					return_type = "void";
				else
					return_type = entry.getValue().getOutputType().toJava();

				String arguments = "";
				boolean first_argument = true;

				for (ArgumentInfo argI : entry.getValue().getArgs()) {
					if (first_argument)
						first_argument = false;
					else
						arguments += ", ";

					arguments += argI.getType() + " " + argI.getName();
				}
				
				
				cw.writeLine(return_type + " " + ng.generateName(entry.getKey())
						+ "(" + arguments + ")");
			}

			cw.openBlock();
			// write function contents
			Instruction function = entry.getValue().getSyntaxTree();
			function.toJava(cw);
			cw.closeBlock();
		}
	}
}