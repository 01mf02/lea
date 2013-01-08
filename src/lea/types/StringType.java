package lea.types;

public class StringType extends Type {
	@Override
	public boolean equals(Type t1) {
		return t1 instanceof StringType;
	}

	public String toString() {
		return "String";
	}

	public String toJava() {
		return "String";
	}

	public String toJavaLength(String e) {
		return "new " + toJava() + "(" + e + ")" + ".length()";
	}
}
