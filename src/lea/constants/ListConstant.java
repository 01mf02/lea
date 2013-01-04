package lea.constants;

import java.util.LinkedList;

import lea.syntax.ConstantLeaf;
import lea.syntax.Expression;
import lea.syntax.ListNode;
import lea.types.ListType;
import lea.types.Type;

public class ListConstant implements Constant {
	LinkedList<Constant> value = null;
	ListType listType;

	public ListConstant(ListNode ln, ListType t) {
		Expression tmp = (Expression) ln.getLeft();
		LinkedList<Constant> nodesValues = new LinkedList<Constant>();

		// Obtient tous les noeuds
		if (tmp.getLeft() != null || tmp.getRight() != null) {
			while ((tmp.getLeft() != null) || (tmp.getRight() != null)) {
				if (tmp.getRight() != null) {
					if (tmp.getRight().getLeft() == null
							&& tmp.getRight().getRight() == null) {
						ConstantLeaf c = (ConstantLeaf) tmp.getRight();
						nodesValues.add(0, c.getValue());
					}
				}
				if (tmp.getLeft() != null) {
					if (tmp.getLeft().getLeft() == null
							&& tmp.getLeft().getRight() == null) {
						ConstantLeaf c = (ConstantLeaf) tmp.getLeft();
						nodesValues.add(0, c.getValue());
					}
				}
				tmp = (Expression) tmp.getLeft();
			}
		}
		value = nodesValues;
		listType = t;
	}

	public Type getType() {
		return listType;
	}

	public String toString() {
		return value.toString();
	}

	public String toJava() {
		String l = "{";
		for (int i = 0; i < value.size(); i++) {
			l += value.get(i).toJava();
			if (i < value.size() - 1)
				l += ", ";
		}
		l += "}";

		return l;
	}
}
