package lea.constants;

import lea.syntax.Tuple;
import lea.types.Type;

public class TupleConstant implements Constant {
	private Tuple tuple;

	public TupleConstant(Tuple l) {
		tuple = l;
	}

	public Type getType() {
		return tuple.getType();
	}

	public String toString() {
		return tuple.toString();
	}

	public String toJava() {
		return tuple.toJava();
	}
}