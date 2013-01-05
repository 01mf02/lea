package lea.syntax;

import lea.types.TupleType;
import lea.types.Type;

public class Pair extends Expression {
	Expression left, right;

	public Pair(Expression a1, Expression a2) {
		super(a1, a2);
		left = a1;
		right = a2;
	}

	public String toString() {
		return "Pair" + super.toString();
	}

	public Type getType() {
		SyntaxTree left = this.getLeft();
		SyntaxTree right = this.getRight();

		Type tLeft = null;
		Type tRight = null;

		if (left != null)
			tLeft = left.getType();

		if (right != null)
			tRight = right.getType();

		return new TupleType(tLeft, tRight);
	}

	public String toDotString() {
		return "Pair";
	}

	public String toJava() {
		return left.toJava() + ", " + right.toJava() + "}";
	}

}
