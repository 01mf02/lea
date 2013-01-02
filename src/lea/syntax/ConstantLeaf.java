package lea.syntax;

import lea.constants.Constant;
import lea.types.Type;

public class ConstantLeaf extends Expression {
	private Constant constValue;

	public ConstantLeaf(Constant c) {
		constValue = c;
	}

	public String getValue() {
		return constValue.toString();
	}

	public Type getType() {
		return constValue.getType();
	}

	public Constant getConstant() {
		return constValue;
	}

	public String toString() {
		return "Const(" + constValue.toString() + ":"
				+ constValue.getType().toString() + ")";
	}

	public String toJava() {
		return constValue.toJava();
	}

	public String toDotString() {
		return this.toString();
	}
}
