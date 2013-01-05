package lea.syntax;

public enum NumberOperator {
	PLUS("+"), MINUS("-"), MINUS_U("-"), MOD("%"), MULT("*"), DIV("/");

	private final String tag;

	NumberOperator(String s) {
		tag = s;
	}

	public String toString() {
		return tag;
	}
}