package lea.syntax;

// TODO: split this up into BoolOperator and NumberOperator
public enum EnumTagExp {
	AND("&&"), OR("||"), LT("<"), GT(">"), LE("<="), GE(">="), EQ("="), DIFF(
			"!="), PLUS("+"), MINUS("-"), MINUS_U("-"), MOD("%"), MULT("*"), DIV(
			"/");

	private final String tag;

	EnumTagExp(String s) {
		tag = s;
	}

	public String toString() {
		return tag;
	}
}