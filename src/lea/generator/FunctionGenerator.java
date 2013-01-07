package lea.generator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map.Entry;

import lea.ArgumentInfo;
import lea.FunctionInfo;
import lea.FunctionTable;
import lea.syntax.Instruction;
import lea.types.IntType;
import lea.types.ListType;
import lea.types.StringType;
import lea.types.Type;

public class FunctionGenerator {

	FunctionTable fctTable;

	public FunctionGenerator(FunctionTable fctTable) {
		this.fctTable = fctTable;
	}

	public boolean generate(CodeWriter cw) throws IOException {

		if (!fctTable.containsKey("main")) {
			System.err.println("main function not found; aborting build.");
			return false;
		}

		for (Entry<String, FunctionInfo> entry : fctTable.entrySet()) {

			cw.writeLine("");

			if (entry.getKey().equals("main")) {
				cw.writeLine("public static void main(String[] args)");
				cw.openBlock();

				FunctionInfo fi = entry.getValue();
				Type outputType = fi.getOutputType();
				LinkedList<ArgumentInfo> args = fi.getArgs();

				if (outputType == null && args.isEmpty())
					cw.writeLine("lea_main();");
				else if (outputType != null
						&& !args.isEmpty()
						&& outputType.equals(new IntType())
						&& args.getFirst().getType()
								.equals(new ListType(new StringType()))) {
					cw.writeLine("int return_code = lea_main(args);");
					cw.writeLine("System.exit(return_code); ");
				} else {
					System.err
							.println("main function does not have valid type; aborting build.");
					return false;
				}

				cw.closeBlock();
			}

			String return_type = "";
			if (entry.getValue().getOutputType() == null)
				return_type = "void";
			else
				return_type = entry.getValue().getOutputType().toJava();

			cw.writeLine("");
			cw.writeLine("public static " + return_type + " "
					+ Generator.generateName(entry.getKey()) + "("
					+ generateArguments(entry.getValue()) + ")");

			cw.openBlock();

			// write function contents
			Instruction function = entry.getValue().getSyntaxTree();
			function.toJava(cw);
			cw.closeBlock();
		}

		return true;
	}

	public String generateArguments(FunctionInfo entry) {
		String arguments = "";
		boolean first_argument = true;

		for (ArgumentInfo argI : entry.getArgs()) {
			if (first_argument)
				first_argument = false;
			else
				arguments += ", ";

			arguments += argI.getType().toJava() + " "
					+ Generator.generateName(argI.getName());
		}

		return arguments;
	}
}