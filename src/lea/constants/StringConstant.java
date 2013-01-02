package lea.constants;

import lea.types.StringType;
import lea.types.Type;

public class StringConstant implements Constant {
	String value = "";
	Type t;

	public StringConstant(String v) {
		value = v;
		t = new StringType();
	}

	public Type getType() {
		return t;
	}

	public String toString() {
		return "'" + value + "'";
	}

	public String toJava() {
		return "\"" + value + "\"";
	}
}
