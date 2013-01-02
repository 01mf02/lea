package lea.syntax;

import lea.types.Type;

public class ListAccessor extends Expression {
	public ListAccessor(Expression a1, Expression a2) {
		super(a1, a2);
	}

	public String toString() {
		return "ListAccess" + super.toString();
	}

	public Type getType() {
		return this.getLeft().getType().getLeft();
	}

	public String toDotString() {
		return "ListAccess";
	}
}
