package lea.syntax;

import lea.types.TupleType;
import lea.types.Type;

public class TupleNode extends Expression {
	Expression left, right;

	public TupleNode(Expression a1, Expression a2) {
		super(a1, a2);
		left = a1;
		right = a2;
	}

	public TupleNode(Expression assignment_left) {
		left = assignment_left;
	}

	public String toString() {
		return "Tuple" + super.toString();
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
		return "Tuple";
	}

	public String toJava() {
		return "new Object[]{" + left.toJava() + ", " + right.toJava() + "}";
	}

}
