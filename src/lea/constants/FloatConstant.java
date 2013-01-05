package lea.constants;

import lea.types.FloatType;
import lea.types.Type;

public class FloatConstant implements Constant {
	float value = 0;
	Type t;

	public FloatConstant(String v) {
		value = Float.parseFloat(v);
		t = new FloatType();
	}

	public Type getType() {
		return t;
	}

	public String toString() {
		return Float.toString(value);
	}

	public String toJava() {
		return toString() + "f";
	}
}