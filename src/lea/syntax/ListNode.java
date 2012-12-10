package lea.syntax;

import lea.types.TupleType;
import lea.types.Type;

public class ListNode extends Expression {
	public ListNode(Expression a1, Expression a2) {
		super(a1, a2);
	}

	public String toString() {
		return "ListNode" + super.toString();
	}

	public Type getType() {
		return new TupleType(this.getLeft().getType(), this.getRight()
				.getType());
	}

	public String toDotString() {
		return "ListNode";
	}
}