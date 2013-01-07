package lea.types;


public class CharType extends Type {
	@Override
	public boolean equals(Type t1) {
		return t1 instanceof CharType;
	}

	public String toString() {
		return "char";
	}

	public String toJava() {
		return "Character";
	}
}
