package lea.syntax;

import lea.generator.Generator;
import lea.types.Type;

public class FunctionCall extends Expression {

	String functionName;
	Type returnType;
	Pair argumentsPair;
	Expression object;

	public FunctionCall(String name, Type type, Pair args, Expression obj) {
		super(obj, args);
		functionName = name;
		returnType = type;
		argumentsPair = args;
		object = obj;
	}

	public String toString() {
		return "FunctionCall" + super.toString();
	}

	public String toDotString() {
		return "FunctionCall";
	}

	public Type getType() {
		return returnType;
	}

	public String toJava() {
		// TODO: uncomment object.toJava() when lea.cup functions
		switch (functionName) {
		case "write":
			return "System.out.print(" + argumentsPair.toJava() + ")";
		case "writeln":
			return "System.out.println(" + argumentsPair.toJava() + ")";
		case "read":
			return "scanner.nextLine()";
		case "length":
			return /* object.toJava() + */".length";
		case "toString":
			return /* object.toJava() + */".toString()";
		}

		String arguments = "";
		if (argumentsPair != null)
			arguments = argumentsPair.toJava();

		return Generator.generateName(functionName) + "(" + arguments + ")";
	}
}
