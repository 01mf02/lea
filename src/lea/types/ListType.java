package lea.types;

import lea.constants.Constant;
import lea.constants.ListConstant;

public class ListType extends Type {
	public ListType(Type t) {
		this.left = t;
	}

	@Override
	public boolean equals(Type t1) {
		if (t1 instanceof ListType) {
			return aux_equals(t1, this);
		}

		return false;
	}

	@Override
	public boolean equals(Constant c1) {
		return c1 instanceof ListConstant && equals(c1.getType());
	}

	public String toString() {
		return "List";
	}

	public String toJava() {
		return this.left.getType() + "[]";

	}
}
