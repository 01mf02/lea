package lea.types;

import lea.constants.BoolConstant;
import lea.constants.Constant;

public class BoolType extends Type {
	@Override
	public boolean equals(Type t1) {
		return t1 instanceof BoolType;
	}

	@Override
	public boolean equals(Constant c1) {
		return c1 instanceof BoolConstant;
	}

	public String toString() {
		return "boolean";
	}

	public String toJava() {
		return "Boolean";
	}
}
