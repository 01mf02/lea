package lea.types;


public class BoolType extends Type {
	@Override
	public boolean equals(Type t1) {
		return t1 instanceof BoolType;
	}

	public String toString() {
		return "boolean";
	}

	public String toJava() {
		return "Boolean";
	}
}
