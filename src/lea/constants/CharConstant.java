package lea.constants;

import lea.types.CharType;
import lea.types.Type;

public class CharConstant implements Constant {
	char value = ' ';
	Type t;

	public CharConstant(String v) {
		value = v.charAt(0);
		t = new CharType();
	}

	public Type getType() {
		return t;
	}

	public char getValue() {
		return value;
	}

	public String toString() {
		return Character.toString(value);
	}

	public String toJava() {
		return "'" + toString() + "'";
	}
}
