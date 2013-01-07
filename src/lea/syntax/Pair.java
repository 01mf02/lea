package lea.syntax;

import java.util.Arrays;
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

	public static LinkedList<Expression> dataToList(Expression data) {
		if (data == null)
			return new LinkedList<Expression>();
		else if (data instanceof Pair)
			return (((Pair) data).toList());
		else
			return new LinkedList<Expression>(Arrays.asList(data));
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
		if (left == null)
			return null;
		if (left instanceof Pair)
			return ((Pair) left).getFirstElementType();
		else
			return left.getType();
	}

	public Type getType() {
		if (left == null && right == null)
			return new PairType(null, null);
		else if (left == null && right != null)
			return new PairType(null, right.getType());
		else if (left != null && right == null)
			return new PairType(left.getType(), null);
		else
			return new PairType(left.getType(), right.getType());
	}

	public String toDotString() {
		return "Pair";
	}

	public String toJava() {
		return left.toJava() + ", " + right.toJava();
	}
}
