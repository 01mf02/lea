package lea.types;

import lea.constants.Constant;

public class PairType extends Type {

	@Override
	public boolean equals(Type t1) {
		return left.equals(t1.left) && right.equals(t1.right);
	}

	@Override
	public boolean equals(Constant c1) {
		return c1 instanceof PairType && equals(c1.getType());
	}

	@Override
	public String toString() {
		return "Pair";
	}

	@Override
	public String toJava() {
		return "This method shall never be called!";
	}

}
