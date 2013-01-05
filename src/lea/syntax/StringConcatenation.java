package lea.syntax;

public class StringConcatenation extends Expression {
	Expression left, right;

	protected StringConcatenation() {

	}

	public StringConcatenation(Expression a1, Expression a2) {
		super(a1, a2);
		left = a1;
		right = a2;
	}

	public String toString() {
		return "StringConcatenation" + super.toString();
	}

	public String toDotString() {
		return "StringConcatenation";
	}

	public String toJava() {
		return left.toJava() + " + " + right.toJava();
	}
}
