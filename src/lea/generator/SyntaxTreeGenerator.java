package lea.generator;

import java.io.IOException;
import java.util.Map.Entry;

import lea.Environment;
import lea.FunctionInfo;
import lea.FunctionTable;
import lea.syntax.*;

public class SyntaxTreeGenerator {

	SyntaxTree node;
	Environment env;
	String str;

	public SyntaxTreeGenerator() {

	}

	public SyntaxTreeGenerator(FunctionTable fctTable) throws IOException {

		

		for (Entry<String, FunctionInfo> entry : fctTable.entrySet()) {
			node = entry.getValue().getSyntaxTree();
			str += treeTranslator(node);
		}


	}

	public String treeTranslator(SyntaxTree st) throws IOException {
		String result = "";

		result += "(";

		if (st == null)
			return "";

		if (st instanceof Instruction) {
			result += new InstructionGenerator((Instruction) st).generate();

		}
		if (st instanceof Expression) {
			result += new ExpressionGenerator((Expression) st).generate();
		}
		if (st instanceof EnumExp) {
			result += treeTranslator(st);

		} else
		{
			//result += "\n\n UNKNOWN  " ;
			//result += st.toString();
		}

		result += ")";

		return result;

	}
	
	public String generate()
	{
		return str;
	}

}
