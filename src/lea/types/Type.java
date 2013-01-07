package lea.types;

/* tree implementing a type*/

public abstract class Type {

	protected Type left;
	protected Type right;

	protected Type() {
		this.left = null;
		this.right = null;
	}

	protected Type(Type left, Type right) {
		this.left = left;
		this.right = right;
	}

	public abstract boolean equals(Type t1);

	public abstract String toString();

	public abstract String toJava();

	protected boolean leftRightEquals(Type t1, Type t2) {
		return equalsOrNull(t1.left, t2.left) && equalsOrNull(t1.right, t2.right);
	}

	private boolean equalsOrNull(Type t1, Type t2) {
		if (t1 == null || t2 == null)
			return true;
		else
			return t1.equals(t2);
	}

	public boolean requiresInitialisation() {
		return false;
	}

	public Type getLeft() {
		return left;
	}

	public void setLeft(Type left) {
		this.left = left;
	}

	public Type getRight() {
		return right;
	}

	public void setRight(Type right) {
		this.right = right;
	}

	public String toJavaEquals(String e1, String e2) {
		return "new " + toJava() + "(" + e1 + ").equals(" + e2 + ")";
	}

	public String toJavaToString(String e) {
		return e + ".toString()";
	}
}
