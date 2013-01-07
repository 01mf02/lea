package lea.types;


public class UnknownType extends Type {
	public UnknownType() {
	}

	@Override
	public boolean equals(Type t1) {
		return false;
	}

	@Override
	public String toString() {
		return "unknown";
	}

	@Override
	public String toJava() {
		return "unknown";
	}
}
