package lea.syntax;

import lea.generator.Generator;
import lea.types.Type;
import lea.types.UnknownType;

public class VariableLeaf extends Expression {
	private String name;
	private Type type;

	public VariableLeaf(String s, Type t) {
		name = s;

		if (t != null)
			type = t;
		else
			type = new UnknownType();
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public String toString() {
		return "Variable(" + name + ":" + type.toString() + ")";
	}

	public String toDotString() {
		return this.toString();
	}

	public String toJava() {
		return Generator.generateName(name);
	}
}
