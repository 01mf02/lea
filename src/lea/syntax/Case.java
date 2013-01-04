package lea.syntax;

import lea.generator.CodeWriter;

public class Case extends Instruction {
	private Expression expression;
	private CaseNode node;

	public Case(Expression a1, CaseNode a2) {
		super(a1, a2);
		expression = a1;
		node = a2;
	}

	public String toString() {
		return "Case" + super.toString();
	}

	public String toDotString() {
		return "Case";
	}

	public void toJava(CodeWriter w) {
		w.writeLine("switch (" + expression.toJava() + ")");
		w.openBlock();

		node.toJava(w);

		w.closeBlock();
		w.writeLine("");

	}
}
