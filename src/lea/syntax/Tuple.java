package lea.syntax;

import lea.types.TupleType;
import lea.types.Type;

public class Tuple extends Expression {

	Pair pair;

	public Tuple(Pair a1) {
		super(a1, null);
		pair = a1;
	}

	public Type getType() {
		// TODO: redo TupleType and remove second null argument!
		return new TupleType(pair.getType(), null);
	}

	public String toString() {
		return "Tuple" + super.toString();
	}

	public String toDotString() {
		return "Tuple";
	}

	public String toJava() {
		return "new Object[] {" + pair.toJava() + "}";
	}
}
