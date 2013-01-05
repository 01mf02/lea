package lea.syntax;

public class NumberExp extends Expression {
	Expression left, right;
	private NumberOperator operator;

	public NumberExp(Expression a1, Expression a2, NumberOperator tag) {
		super(a1, a2);
		operator = tag;
		left = a1;
		right = a2;
	}

	public String toString() {
		return "NumberExp(" + operator + ")" + super.toString();
	}

	public String toDotString() {
		return "NumberExp(" + operator + ")";
	}

	public String toJava() {
		if (right == null)
			// unary operators, like MINUS_U
			return operator + " " + left.toJava();
		else
			// binary operators
			return left.toJava() + " " + operator + " " + right.toJava();
	}
}
