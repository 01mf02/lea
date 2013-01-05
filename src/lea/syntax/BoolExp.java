package lea.syntax;

import lea.types.BoolType;
import lea.types.Type;

public class BoolExp extends Expression {
	Expression left, right;
	private BoolOperator operator;

	public BoolExp(Expression a1, Expression a2, BoolOperator tag) {
		super(a1, a2);
		operator = tag;
		left = a1;
		right = a2;
	}

	public String toString() {
		return "BooleanExp(" + operator + ")" + super.toString();
	}

	public String toJava() {
		if (operator == BoolOperator.EQ)
			return left.toJavaEquals(right);
		else if (operator == BoolOperator.DIFF)
			return "!(" + left.toJavaEquals(right) + ")";
		else
			return left.toJava() + " " + operator + " " + right.toJava();
	}

	public Type getType() {
		return new BoolType();
	}

	public String toDotString() {
		return "BooleanExp(" + operator + ")";
	}
}
