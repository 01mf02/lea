package lea.syntax;

import lea.generator.CodeWriter;

public class CaseNode extends Instruction {
	protected String enumValue;
	protected Instruction inst;
	protected CaseNode next;

	public CaseNode(String value, Instruction a1, CaseNode a2) {
		super(a1, a2);
		enumValue = value;
		inst = a1;
		next = a2;
	}

	public String toString() {
		return "CaseNode" + super.toString();
	}

	public String toDotString() {
		return "CaseNode";
	}

	public void toJava(CodeWriter w) {
		w.writeLine("case " + enumValue + ":");
		w.openBlock();
		inst.toJava(w);
		w.writeLine("break;");
		w.closeBlock();

		if (next != null)
			next.toJava(w);
	}
}
