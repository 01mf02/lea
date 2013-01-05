package lea.types;

import lea.constants.Constant;
import lea.constants.TupleConstant;

public class TupleType extends Type {
	public TupleType(Type t) {
		super(t, null);
	}

	@Override
	public boolean equals(Type t1) {
		if (t1 instanceof TupleType)
			return left.equals(t1.left);
		else
			return false;
	}

	@Override
	public boolean equals(Constant c1) {
		return c1 instanceof TupleConstant && equals(c1.getType());
	}

	public String toString() {
		return "Tuple";
	}

	public String toJava() {
		return "Object[]";
	}
}
