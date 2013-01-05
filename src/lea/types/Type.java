package lea.types;

import lea.constants.Constant;

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

	public abstract boolean equals(Constant c1);

	protected boolean aux_equals(Type t1, Type t2) {
		boolean equals = true;

		// Comparaison a gauche
		if (t1.left != null && t2.left != null)
			equals = aux_equals(t1.left, t2.left);
		else if (!(t1.left == null && t1.left == null))
			equals = false;

		// Comparaison a droite
		if (t1.right != null && t2.right != null && equals)
			equals = aux_equals(t1.right, t2.right);
		else if (!(t1.right == null && t1.right == null))
			equals = false;

		if (t1.left == null && t1.right == null && equals)
			equals = t1.equals(t2);

		return equals;
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

	public abstract String toString();

	public abstract String toJava();

	public String toJavaEquals(String e1, String e2) {
		return e1 + ".equals(" + e2 + ")";
	}

	public String toJavaToString(String e) {
		return e + ".toString()";
	}
}
