package lea.syntax;

import lea.types.Type;

public class Expression extends SyntaxTree {
	protected Expression() {
		super();
	}

	public Expression(Expression a1, Expression a2) {
		super(a1, a2);
	}

	public Type getType() {
		return this.getLeft().getType();
	}

	public String toString() {
		return "Expression" + super.toString();
	}

	public String toJava() {
		return "unhandled_expression";
	}

	public String toJavaEquals(Expression right) {
		return getType().toJavaEquals(this.toJava(), right.toJava());
	}

	public String toJavaToString() {
		return getType().toJavaToString(this.toJava());
	}

	public String toDotString() {
		return "Expression";
	}

}
