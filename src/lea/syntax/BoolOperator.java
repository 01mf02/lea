package lea.syntax;

public enum BoolOperator {
	AND("&&"), OR("||"), LT("<"), GT(">"), LE("<="), GE(">="), EQ("="), DIFF(
			"!=");

	private final String tag;

	BoolOperator(String s) {
		tag = s;
	}

	public String toString() {
		return tag;
	}

}
