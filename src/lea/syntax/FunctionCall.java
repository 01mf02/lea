package lea.syntax;

import lea.types.ListType;

public class FunctionCall extends Expression {
	FunctionRef fRef;
	Expression exp;

	public FunctionCall(FunctionRef a1, Expression a2) {
		super(a1, a2);
		fRef = a1;
		exp = a2;

	}

	public String toString() {
		return "FunctionCall" + super.toString();
	}

	public String toDotString() {
		return "Call";
	}

	public String toJava() {
		if (exp != null) {
			if (exp.getType() instanceof ListType)
				return fRef.toJava() + "new " + exp.getType().toJava() + " "
						+ exp.toJava() + ")";
			else {
				if (exp.toJava().equalsIgnoreCase("null()"))
					return fRef.toJava() + ")";
				else
					return fRef.toJava() + exp.toJava() + ")";
			}
		}

		else
			return fRef.toJava() + ")";

	}
}
