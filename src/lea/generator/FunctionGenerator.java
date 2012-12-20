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

		if (fctTable.containsKey("main")) {

			for (Entry<String, FunctionInfo> entry : fctTable.entrySet()) {

				cw.writeLine("");

				if (entry.getKey().equals("main")) {
					cw.writeLine("public static void main(String[] args)");
					cw.openBlock();
					if (entry.getValue().getOutputType() == null)
						cw.writeLine("lea_main();");
					else
						cw.writeLine("int return_code = lea_main()");
					cw.closeBlock();
				}

				String return_type = "";
				if (entry.getValue().getOutputType() == null)
					return_type = "void";
				else
					return_type = entry.getValue().getOutputType().toJava();

				cw.writeLine("");
				cw.writeLine("public " + return_type + " "
						+ ng.generateName(entry.getKey()) + "("
						+ argsGenerator(entry.getValue()) + ")");

				cw.openBlock();
				// write function contents
				Instruction function = entry.getValue().getSyntaxTree();
				function.toJava(cw);
				cw.closeBlock();
			}
		}
		else
			System.err.println("main function not found; aborting build.");
	}

	public String argsGenerator(FunctionInfo entry) {
		String arguments = "";
		boolean first_argument = true;

		for (ArgumentInfo argI : entry.getArgs()) {
			if (first_argument)
				first_argument = false;
			else
				arguments += ", ";

			arguments += argI.getType().toJava() + " " + argI.getName();
		}

		return arguments;
	}

}