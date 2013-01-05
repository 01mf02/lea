package lea.syntax;

import java.util.LinkedList;

import lea.types.ListType;
import lea.types.Type;

public class ListNode extends Expression {
	public ListNode(Expression a1, Expression a2) {
		super(a1, a2);
	}

	public String toString() {
		return "ListNode" + super.toString();
	}

	public Type getType() {
		SyntaxTree st = this.getLeft();
		Type type = getNodes().get(0).getType();

		while (st != null) {
			if (st instanceof ListNode)
				type = new ListType(type);

			st = st.getLeft();
		}

		return new ListType(type);
	}

	private LinkedList<Expression> getNodes() {
		Expression tmp = (Expression) this.getLeft();
		LinkedList<Expression> nodes = new LinkedList<Expression>();

		// Obtient tous les noeuds
		if (tmp.getLeft() != null || tmp.getRight() != null) {
			while ((tmp.getLeft() != null) || (tmp.getRight() != null)) {
				if (tmp.getRight() != null) {
					if (tmp.getRight().getLeft() == null
							&& tmp.getRight().getRight() == null)
						nodes.add((Expression) tmp.getRight());
				}
				if (tmp.getLeft() != null) {
					if (tmp.getLeft().getLeft() == null
							&& tmp.getLeft().getRight() == null)
						nodes.add((Expression) tmp.getLeft());
				}
				tmp = (Expression) tmp.getLeft();
			}
		} else
			nodes.add(tmp);

		return nodes;
	}

	public boolean isListHasAllSameType() {
		LinkedList<Expression> nodes = getNodes();

		for (int i = 0; i < nodes.size() - 1; i++) {
			if (!nodes.get(i).getType().equals(nodes.get(i + 1).getType())) {
				return false;
			}
		}

		return true;
	}

	public String toDotString() {
		return "ListNode";
	}

	public String toJava() {
		LinkedList<Expression> nodes = getNodes();

		String l = "new " + getType().toJava() + " {";
		for (int i = 0; i < nodes.size(); i++) {
			l += nodes.get(i).toJava();
			if (i < nodes.size() - 1)
				l += ", ";
		}
		l += "}";

		return l;
	}
}