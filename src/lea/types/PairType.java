package lea.types;


public class PairType extends Type {

	public PairType(Type t1, Type t2) {
		super(t1, t2);
	}

	@Override
	public boolean equals(Type t1) {
		if (t1 instanceof PairType)
			return leftRightEquals(t1, this);

		return false;
	}

	@Override
	public String toString() {
		return "pair(" + left + ", " + right + ")";
	}

	@Override
	public String toJava() {
		return "This method shall never be called!";
	}

}
