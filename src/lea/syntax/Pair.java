package lea.syntax;

import java.util.LinkedList;

import lea.types.PairType;
import lea.types.Type;

public class Pair extends Expression {
	Expression left, right;

	public Pair(Expression a1, Expression a2) {
		super(a1, a2);
		left = a1;
		right = a2;
	}

	public String toString() {
		return "Pair" + super.toString();
	}

	public LinkedList<Expression> toList() {
		LinkedList<Expression> result = new LinkedList<Expression>();

		addToList(result, left);
		addToList(result, right);

		return result;
	}

	private static void addToList(LinkedList<Expression> list, Expression elem) {
		if (elem != null) {
			if (elem instanceof Pair)
				list.addAll(((Pair) elem).toList());
			else
				list.add(elem);
		}
	}

	public Type getFirstElementType() {
		if (left instanceof Pair)
			return ((Pair) left).getFirstElementType();
		else
			return left.getType();
	}

	public Type getType() {
		return new PairType(left.getType(), right.getType());
	}

	public String toDotString() {
		return "Pair";
	}

	public String toJava() {
		return left.toJava() + ", " + right.toJava();
	}

}
