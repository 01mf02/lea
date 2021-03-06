package lea.syntax;

import lea.generator.Generator;
import lea.types.Type;

public class FunctionCall extends Expression {

	String functionName;
	Type returnType;
	Tuple argumentsTuple;
	Expression object;

	public FunctionCall(String name, Type type, Tuple args, Expression obj) {
		super(obj, args);
		functionName = name;
		returnType = type;
		argumentsTuple = args;
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
		String arguments = argumentsTuple.toJavaFunctionArguments();

		switch (functionName) {
		case "write":
			return "System.out.print" + arguments;
		case "writeln":
			return "System.out.println" + arguments;
		case "read":
			return "scanner.nextLine()";
		case "length":
			return object.getType().toJavaLength(object.toJava());
		case "toString":
			return object.getType().toJavaToString(object.toJava());
		}

		return Generator.generateName(functionName) + arguments;
	}
}
