package lea;

import java.util.LinkedList;

import lea.syntax.Instruction;
import lea.types.Type;

public class FunctionInfo {
	private LinkedList<ArgumentInfo> args;
	private Type outputType;
	private Instruction sTree;

	public FunctionInfo() {
		this(new LinkedList<ArgumentInfo>(), null, null);
	}

	public FunctionInfo(LinkedList<ArgumentInfo> lArgs, Type outputT,
			Instruction s) {
		args = lArgs;
		outputType = outputT;
		sTree = s;
	}

	public FunctionInfo(LinkedList<ArgumentInfo> lArgs, Type outputT) {
		args = lArgs;
		outputType = outputT;
		sTree = new Instruction(null, null);
	}

	public String toString() {
		String str = "(" + args.toString() + ")";

		if (outputType != null) {
			str += " : " + outputType.toString();
		}

		// uncomment this line to get a syntax tree preview
		// str += " { " + sTree.toString() + " } ";

		return str;
	}

	public void pushArg(String name, Type t) {
		args.add(new ArgumentInfo(name, t));
	}

	public void setOutputType(Type t) {
		outputType = t;
	}

	public void setSyntaxTree(Instruction s) {
		sTree = s;
	}

	public LinkedList<ArgumentInfo> getArgs() {
		return args;
	}

	public Type getOutputType() {
		return outputType;
	}

	public Instruction getSyntaxTree() {
		return sTree;
	}
}
