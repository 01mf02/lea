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

	public String getValue() {
		return "\"" + value + "\"";
	}

	public String toString() {
		return getValue();
	}

	public String toJava() {
		return toString();
	}
}
