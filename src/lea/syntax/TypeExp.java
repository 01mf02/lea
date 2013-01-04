package lea.syntax;

import lea.types.Type;
import lea.types.UnknownType;

public class TypeExp extends Expression {
	private Type type;

	public TypeExp(Type t) {
		if (t != null)
			type = t;
		else
			type = new UnknownType();
	}

	public Type getType() {
		return type;
	}

	public String toString() {
		return "TypeExp(" + type.toString() + ")";
	}

	public String toJava() {
		return type.toJava();
	}

	public String toDotString() {
		return this.toString();
	}
}
