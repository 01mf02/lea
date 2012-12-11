package lea.syntax;
import lea.types.*;


public class ListNode extends Expression {
	public ListNode(Expression a1, Expression a2) {
		super(a1, a2);
	}

	public String toString() {
		return "ListNode" + super.toString();
	}

	public Type getType() {
		if(this.getRight() != null)
			return new TupleType(this.getLeft().getType(), this.getRight().getType());
		else
			return new ListType(this.getLeft().getType());
	}

	public String toDotString() {
		return "ListNode";
	}
}