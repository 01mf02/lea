package lea.types;


public class IntType extends Type {
	@Override
	public boolean equals(Type t1) {
		return t1 instanceof IntType;
	}

	public String toString() {
		return "int";
	}

	public String toJava() {
		return "Integer";
	}
}
