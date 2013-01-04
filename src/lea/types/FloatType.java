package lea.types;

import lea.constants.Constant;
import lea.constants.FloatConstant;

public class FloatType extends Type {
	@Override
	public boolean equals(Type t1) {
		return t1 instanceof FloatType;
	}

	@Override
	public boolean equals(Constant c1) {
		return c1 instanceof FloatConstant;
	}

	public String toString() {
		return "float";
	}

	public String toJava() {
		return "Float";
	}
}
