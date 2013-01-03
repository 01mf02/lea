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
		
		if(return_expr != null)
			cw.writeLine("return " + return_expr.toJava() + ";");
		else
			cw.writeLine("return;");
	}

	public String toDotString() {
		return "Return";
	}
}
