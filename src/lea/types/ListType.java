package lea.types;


public class ListType extends Type {

	public ListType(Type t) {
		super(t, null);
	}

	@Override
	public boolean equals(Type t1) {
		if (t1 instanceof ListType)
			return leftRightEquals(t1, this);

		return false;
	}

	@Override
	public String toString() {
		return "list of " + this.left;
	}

	@Override
	public String toJava() {
		return this.left.toJava() + "[]";
	}

	public String toJavaEquals(String e1, String e2) {
		return "Arrays.equals(" + e1 + ", " + e2 + ")";
	}

	public String toJavaToString(String e) {
		return "Arrays.toString(" + e + ")";
	}
}
