package lea.syntax;

import lea.types.Type;
import lea.types.UnknownType;

public class TypeExp extends Expression {
	private Type objectType;

	public TypeExp(Type t) {
		if (t != null)
			objectType = t;
		else
			objectType = new UnknownType();
	}

	public Type getType() {
		return objectType.getType();
	}

	public String toString() {
		return "TypeExp(" + objectType.toString() + ")";
	}

	public String toDotString() {
		return this.toString();
	}
}
