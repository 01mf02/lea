package lea.syntax;

import lea.generator.Generator;
import lea.types.Type;

public class FunctionCallNew extends Expression {

	String functionName;
	Type returnType;
	Pair arguments;
	Expression object;

	FunctionCallNew(String name, Type type, Pair args, Expression obj) {
		super(obj, args);
		functionName = name;
		returnType = type;
		arguments = args;
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
		switch (functionName) {
		case "write":
			return "System.out.print(" + arguments.toJava() + ")";
		case "writeln":
			return "System.out.println(" + arguments.toJava() + ")";
		case "read":
			return "scanner.nextLine()";
		case "length":
			return object.toJava() + ".length";
		case "toString":
			return object.toJava() + ".toString()";
		}

		return Generator.generateName(functionName) + "(" + arguments.toJava()
				+ ")";
	}
}
