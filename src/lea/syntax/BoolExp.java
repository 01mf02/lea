package lea.syntax;

import lea.types.BoolType;
import lea.types.Type;

public class BoolExp extends Expression {
	Expression left, right;
	private EnumTagExp expTag;

	protected BoolExp() {

	}

	public BoolExp(Expression a1, Expression a2, EnumTagExp tag) {
		super(a1, a2);
		expTag = tag;
		left = a1;
		right = a2;
	}

	public String toString() {
		return "BooleanExp(" + expTag.toString() + ")" + super.toString();
	}

	public String toJava() {
		if (expTag == EnumTagExp.EQ || expTag == EnumTagExp.DIFF) {
			String result = left.toJava() + ".equals(" + right.toJava() + ")";
			if (expTag == EnumTagExp.DIFF)
				result = "!(" + result + ")";
			return result;
		} else
			return left.toJava() + " " + expTag + " " + right.toJava();
	}

	public Type getType() {
		return new BoolType();
	}

	public String toDotString() {
		return "BooleanExp(" + expTag + ")";
	}
}
