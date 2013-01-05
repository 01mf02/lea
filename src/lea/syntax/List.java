package lea.syntax;

import lea.types.ListType;
import lea.types.Type;

public class List extends Expression {

	Pair pair;

	public List(Pair a1) {
		super(a1, null);
		pair = a1;
	}

	public Type getType() {
		// TODO: check if all elements have same type!
		return new ListType(pair.getType());
	}

	public String toString() {
		return "List" + super.toString();
	}

	public String toDotString() {
		return "List";
	}

	public String toJava() {
		return "new " + getType().toJava() + " {" + pair.toJava() + "}";
	}
}
