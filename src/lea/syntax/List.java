package lea.syntax;

import java.util.LinkedList;

import lea.types.ListType;
import lea.types.Type;

public class List extends Expression {

	Expression data;

	public List(Expression a1) {
		super(a1, null);
		data = a1;
	}

	public Type getType() {
		if (data == null)
			return new ListType(null);
		else if (data instanceof Pair)
			return new ListType(((Pair) data).getFirstElementType());
		else
			return new ListType(data.getType());
	}

	public LinkedList<Expression> toList() {
		return Pair.dataToList(data);
	}

	public boolean isValid() {
		LinkedList<Expression> list = toList();
		Type type = getType().getLeft();

		for (int i = 0; i < list.size(); i++)
			if (list.get(i) != null && !(list.get(i).getType().equals(type)))
				return false;

		return true;
	}

	public String toString() {
		return "List" + super.toString();
	}

	public String toDotString() {
		return "List";
	}

	public String toJava() {
		if (data == null)
			// this is no desired behaviour, but "{}" yields compilation errors
			return "null";
		else
			return "new " + getType().toJava() + " {" + data.toJava() + "}";
	}
}
