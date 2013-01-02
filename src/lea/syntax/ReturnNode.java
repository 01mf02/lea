package lea.syntax;

import lea.generator.CodeWriter;

public class ReturnNode extends Instruction {
	Expression return_expr;

	public ReturnNode(Expression a1) {
		super(a1, null);
		return_expr = a1;
	}

	public String toString() {
		return "Return" + super.toString();
	}

	public void toJava(CodeWriter cw) {
		cw.writeLine("return " + return_expr.toJava() + ";");
	}

	public String toDotString() {
		return "Return";
	}
}
