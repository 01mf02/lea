package lea.syntax;

import java.util.LinkedList;

import lea.types.TupleType;
import lea.types.Type;

public class Tuple extends Expression {

	Expression data;

	public Tuple(Expression a1) {
		super(a1, null);
		data = a1;
	}

	public Type getType() {
		if (data == null)
			return new TupleType(null);
		else
			return new TupleType(data.getType());
	}

	public LinkedList<Expression> toList() {
		return Pair.dataToList(data);
	}

	public String toString() {
		return "Tuple" + super.toString();
	}

	public String toDotString() {
		return "Tuple";
	}

	public String toJava() {
		if (data == null)
			return "new Object[] {}";
		else
			return "new Object[] {" + data.toJava() + "}";
	}

	public String toJavaFunctionArguments() {
		if (data == null)
			return "()";
		else
			return "(" + data.toJava() + ")";
	}
}
