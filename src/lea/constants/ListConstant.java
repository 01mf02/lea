package lea.constants;

import java.util.LinkedList;

import lea.syntax.ConstantLeaf;
import lea.syntax.Expression;
import lea.syntax.ListNode;
import lea.types.ListType;
import lea.types.Type;

public class ListConstant implements Constant {
	// TODO changer list pour constant list
	LinkedList<String> value = null;
	ListType listType;

	public ListConstant(ListNode ln, ListType t) {
		Expression tmp = (Expression) ln.getLeft();
		LinkedList<String> nodesValues = new LinkedList<String>();

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

	public LinkedList<String> getValue() {
		return value;
	}

	public String toString() {
		return value.toString();
	}

	public String toJava() {
		String l = "{";
		for (int i = 0; i < value.size() - 1; i++)
			l += value.get(i) + ", ";
		l += value.get(value.size() - 1) + "}";
		return l;
	}
}
