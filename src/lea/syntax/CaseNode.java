package lea.syntax;

import lea.constants.Constant;
import lea.generator.CodeWriter;

public class CaseNode extends Instruction {
	protected Constant value;
	protected Instruction inst;
	protected CaseNode next;

	public CaseNode(Constant v, Instruction a1, CaseNode a2) {
		super(a1, a2);
		value = v;
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
		w.writeLine("case " + value.toJava() + ":");
		w.openBlock();
		inst.toJava(w);
		w.writeLine("break;");
		w.closeBlock();

		if (next != null)
			next.toJava(w);
	}
}
