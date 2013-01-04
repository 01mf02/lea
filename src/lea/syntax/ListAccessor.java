package lea.syntax;

import lea.types.Type;

public class ListAccessor extends Expression {

	private Expression list, index;

	public ListAccessor(Expression a1, Expression a2) {
		super(a1, a2);
		list = a1;
		index = a2;
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

	public String toJava() {
		return list.toJava() + "[" + index.toJava() + "]";
	}
}
