package lea.types;


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

	public String toString() {
		return "tuple(" + left + ")";
	}

	public String toJava() {
		return "Object[]";
	}

	public String toJavaEquals(String e1, String e2) {
		return "Arrays.equals(" + e1 + ", " + e2 + ")";
	}

	public String toJavaToString(String e) {
		return "Arrays.toString(" + e + ")";
	}
}
