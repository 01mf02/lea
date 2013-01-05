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

	public String toDotString() {
		return "Expression";
	}

}
