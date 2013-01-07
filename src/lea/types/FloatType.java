package lea.types;


public class FloatType extends Type {
	@Override
	public boolean equals(Type t1) {
		return t1 instanceof FloatType;
	}

	public String toString() {
		return "float";
	}

	public String toJava() {
		return "Float";
	}
}
